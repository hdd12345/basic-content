package com.shop.service;

import java.util.List;

import com.shop.entity.MyList;
import com.shop.entity.Orders;

public interface OrdersService {
	//批量添加订单
	public int insertManyOrders(MyList myList) throws Exception;
	//根据用户id查询订单，按时间降序排序
	public List<Orders> selectOrdersByUser_id(int user_id) throws Exception;
	//通过店铺id查询订单，按时间降序排序（关联查询订单中包含的订单明细）
	public List<Orders> selectOrdersByShop_id(int shop_id) throws Exception;
	//通过店铺id及订单状态查询订单，按时间升序排序
	public List<Orders> selectOrdersByState(int shop_id,String orders_state) throws Exception;
	//修改订单状态
	public int updateOrdersState(String state,int orders_id) throws Exception;
	//模糊查询订单
	public List<Orders> selectOrders(String key_word,int user_id) throws Exception;
	//添加订单及订单明细
	public int insertOrders_detail(Orders orders) throws Exception;
}
