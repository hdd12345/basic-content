package com.shop.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.entity.Goods;
import com.shop.entity.MyList;
import com.shop.entity.Orders;
import com.shop.entity.Orders_detail;
import com.shop.entity.User;
import com.shop.mapper.GoodsMapper;
import com.shop.mapper.OrdersMapper;
import com.shop.mapper.Orders_detailMapper;
import com.shop.mapper.UserMapper;
import com.shop.service.OrdersService;
import com.shop.util.DateUtil;
import com.shop.util.ShopUtil;
@Service("ordersServiceImpl")
public class OrdersServiceImpl implements OrdersService{
	@Resource(name="ordersMapper")
	private OrdersMapper ordersMapper;
	@Resource(name="orders_detailMapper")
	private Orders_detailMapper orders_detailMapper;
	@Resource(name="userMapper")
	private UserMapper userMapper;
	@Resource(name="goodsMapper")
	private GoodsMapper goodsMapper;
	
	/**
	 * 批量添加订单及订单明细
	 */
	@Override
	public int insertManyOrders(MyList myList) throws Exception {
		User user = userMapper.selectUserByUser_id(myList.getOrdersList().get(0).getUser_id());
		double actual_total_price=0;
		//计算总金额,并判断库存是否充足
		for(Orders orders:myList.getOrdersList()) {
			for(Orders_detail orders_detail:orders.getOrders_detail_list()) {
				actual_total_price+=orders_detail.getTotal_price();
				//判断库存，若库存不足，return 0
				if(goodsMapper.selectGoodsByGoods_id(orders_detail.getGoods_id()).getNumber()
						<orders_detail.getQuantity()) {
					return 0;
				}
			}
		}
		if(user.getBalance()>=actual_total_price) {
			int count=0;//用于记录总共添加的订单明细数量
			for(Orders orders:myList.getOrdersList()) {
				//生成订单号,规则：年月日+三位随机数+当天订单数
				String date = DateUtil.dateFormat("YYYYMMdd");
				int ordersCount = ordersMapper.selectOrdersByDate(date).size()+1;
				String orders_num = date+ShopUtil.getRandomNum(3)+ordersCount;				
				//计算该笔订单总价
				int orders_total_price=0;
				for(Orders_detail orders_detail:orders.getOrders_detail_list()) {
					orders_total_price+=orders_detail.getTotal_price();
				}
				//补全orders对象属性
				orders.setOrders_num(orders_num);
				orders.setOrders_time(new Date());
				orders.setOrders_total_price(orders_total_price);
				//添加订单
				ordersMapper.insertOrders(orders);
				//减少商品库存，获取返回主键，添加订单明细
				for(Orders_detail orders_detail:orders.getOrders_detail_list()) {
					Goods goods = goodsMapper.selectGoodsByGoods_id(orders_detail.getGoods_id());
					goods.setNumber(goods.getNumber()-orders_detail.getQuantity());
					goodsMapper.updateGoods(goods);
					orders_detail.setOrders_id(orders.getOrders_id());
					count+=orders_detailMapper.insertOrders_detail(orders_detail);
				}
			}
			//扣除余额
			user.setBalance(user.getBalance()-actual_total_price);
			userMapper.updateUser(user);
			return count;
		}
		return 0;
	}
	
	/**
	 * 根据用户id查询订单
	 */
	@Override
	public List<Orders> selectOrdersByUser_id(int user_id) throws Exception {
		return ordersMapper.selectOrdersByUser_id(user_id);
	}
	
	/**
	 * 根据店铺id查询订单
	 */
	@Override
	public List<Orders> selectOrdersByShop_id(int shop_id) throws Exception {
		return ordersMapper.selectOrdersByShop_id(shop_id);
	}
	
	/**
	 * 根据店铺id及订单状态查询订单
	 */
	@Override
	public List<Orders> selectOrdersByState(int shop_id, String orders_state) throws Exception {
		return ordersMapper.selectOrdersByState(shop_id, orders_state);
	}
	
	/**
	 * 修改订单状态
	 */
	@Override
	public int updateOrdersState(String state, int orders_id) throws Exception {
		return ordersMapper.updateOrders_state(state, orders_id);
	}
	
	/**
	 * 模糊查询订单
	 */
	@Override
	public List<Orders> selectOrders(String key_word, int user_id) throws Exception {
		return ordersMapper.selectOrders(key_word, user_id);
	}
	
	/**
	 * 添加订单及订单明细
	 * 传入的orders对象包含属性：user_id,shop_id,address_id,orders_detail_list
	 * orders_detail对象包含属性：goods_id.quantity,total_price
	 * 若余额不足，不予生成订单
	 * 生成订单主键返回，
	 */
	@Override
	public int insertOrders_detail(Orders orders) throws Exception {
		User user = userMapper.selectUserByUser_id(orders.getUser_id());
		Orders_detail orders_detail = orders.getOrders_detail_list().get(0);
		Goods goods = goodsMapper.selectGoodsByGoods_id(orders_detail.getGoods_id());
		//判断库存，若库存不足，return 0
		if(goods.getNumber()<orders_detail.getQuantity()) {
			return 0;
		}
		//判断余额是否足够
		if(user.getBalance()>=orders_detail.getTotal_price()) {
			//生成订单号,规则：年月日+三位随机数+当天订单数
			String date = DateUtil.dateFormat("YYYYMMdd");
			int ordersCount = ordersMapper.selectOrdersByDate(date).size()+1;
			String orders_num = date+ShopUtil.getRandomNum(3)+ordersCount;
			//补全orders对象属性
			orders.setOrders_num(orders_num);
			orders.setOrders_time(new Date());
			orders.setOrders_total_price(orders_detail.getTotal_price());
			if(ordersMapper.insertOrders(orders)>0) {
				//扣除余额
				user.setBalance(user.getBalance()-orders.getOrders_total_price());
				userMapper.updateUser(user);
				//修改库存
				goods.setNumber(goods.getNumber()-orders_detail.getQuantity());
				goodsMapper.updateGoods(goods);
				//获取返回的主键
				orders_detail.setOrders_id(orders.getOrders_id());
				return orders_detailMapper.insertOrders_detail(orders_detail);
			}
		}
		return 0;
	}

}
