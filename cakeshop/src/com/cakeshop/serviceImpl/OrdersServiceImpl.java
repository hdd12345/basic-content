package com.cakeshop.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cakeshop.entity.CartitemInfo;
import com.cakeshop.entity.Orders;
import com.cakeshop.entity.OrdersInfo;
import com.cakeshop.entity.Ordersitem;
import com.cakeshop.entity.OrdersitemInfo;
import com.cakeshop.mapper.CartitemMapper;
import com.cakeshop.mapper.OrdersMapper;
import com.cakeshop.mapper.OrdersitemMapper;
import com.cakeshop.service.OrdersService;
import com.cakeshop.util.CommonUtil;

@Service("ordersServiceImpl")
public class OrdersServiceImpl implements OrdersService {
	
	@Resource(name="ordersMapper")
	OrdersMapper ordersMapper;
	@Resource(name="ordersitemMapper")
	OrdersitemMapper ordersitemMapper;
	@Resource(name="cartitemMapper")
	CartitemMapper cartitemMapper;
	

//	@Override
//	public int insertOrders(OrdersInfo ordersInfo) throws Exception {
//		int count =0;//用于记录更新数据库记录的条数
//		Orders orders = new Orders();
//		orders.setOrders_id(UUID.randomUUID().toString().replace("-",""));
//		orders.setAddress_id(ordersInfo.getAddress_id());
//		orders.setOrders_time(new Date());
//		orders.setOrders_total_price(ordersInfo.getOrders_total_price());
//		orders.setUser_id(ordersInfo.getUser_id());
//		//生成订单号,规则：年月日+三位随机数+当天订单数
//		String date = CommonUtil.dateFormat("YYYYMMdd");
//		int ordersCount = ordersMapper.selectOrdersCount(date)+1;
//		String orders_num = date+CommonUtil.getRandomNum(3)+ordersCount;
//		orders.setOrders_num(orders_num);
//		//添加订单
//		count+=ordersMapper.insertOrders(orders);
//		//添加订单项
//		List<OrdersitemInfo> list = ordersInfo.getList();
//		for(OrdersitemInfo osi:list){
//			Ordersitem ordersitem = new Ordersitem();
//			ordersitem.setOrdersitem_id(UUID.randomUUID().toString().replace("-",""));
//			ordersitem.setOrders_id(orders.getOrders_id());
//			ordersitem.setGoods_id(osi.getGoods_id());
//			ordersitem.setQuantity(osi.getQuantity());
//			ordersitem.setTotal_price(osi.getTotal_price());
//			count+=ordersitemMapper.insertOrdersitem(ordersitem);
//		}
//		return count;
//	}
	
	/**
	 * 根据用户id查询订单
	 */
	@Override
	public List<OrdersInfo> selectOrdersByUser_id(String user_id) throws Exception {
		return ordersMapper.selectOrdersByUser_id(user_id);
	}
	
	/**
	 * 根据订单id查询订单（关联查询）
	 */
	@Override
	public OrdersInfo selectOrdersByOrders_id(String orders_id) throws Exception {
		return ordersMapper.selectOrdersByOrders_id(orders_id);
	}
	
	/**
	 * 添加订单
	 */
	@Override
	public Orders insertOrders(String[] cartitem_ids,String user_id,String address_id) throws Exception {
		int count = 0;
		List<Ordersitem> list = new ArrayList<>();
		double orders_total_price = 0;//订单总价
		for(String cartitem_id:cartitem_ids){
			Ordersitem ordersitem = new Ordersitem();
			CartitemInfo cartitemInfo = cartitemMapper.selectByCartitem_id(cartitem_id);
			ordersitem.setGoods_id(cartitemInfo.getGoods_id());
			ordersitem.setQuantity(cartitemInfo.getQuantity());
			//订单项总价=数量*商品单价
			double total_price = cartitemInfo.getQuantity()*cartitemInfo.getGoods().getGprice();
			ordersitem.setTotal_price(total_price);
			ordersitem.setOrdersitem_id(UUID.randomUUID().toString().replace("-",""));
			list.add(ordersitem);//此时订单项还缺少订单id属性
			orders_total_price+=total_price;//累加订单总价
		}
		Orders orders = new Orders();
		orders.setOrders_id(UUID.randomUUID().toString().replace("-",""));
		orders.setOrders_total_price(orders_total_price);
		orders.setUser_id(user_id);
		orders.setOrders_time(new Date());
		orders.setAddress_id(address_id);
		//生成订单号,规则：年月日+三位随机数+当天订单数
		String date = CommonUtil.dateFormat("YYYYMMdd");
		int ordersCount = ordersMapper.selectOrdersCount(date)+1;
		String orders_num = date+CommonUtil.getRandomNum(3)+ordersCount;
		orders.setOrders_num(orders_num);
		//添加订单
		count+=ordersMapper.insertOrders(orders);
		//添加订单项
		for(Ordersitem os:list){
			os.setOrders_id(orders.getOrders_id());
			count+=ordersitemMapper.insertOrdersitem(os);
		}
		cartitemMapper.deleteCartitems(cartitem_ids);//删除购物车明细
		return orders;
	}
	
	/**
	 * 修改订单状态
	 */
	@Override
	public int updateOrders(String orders_num) throws Exception {
		return ordersMapper.updateState(orders_num);
	}

}
