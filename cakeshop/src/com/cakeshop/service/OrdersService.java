package com.cakeshop.service;

import java.util.List;

import com.cakeshop.entity.Orders;
import com.cakeshop.entity.OrdersInfo;

public interface OrdersService {
//	//添加订单
//	public int insertOrders(OrdersInfo ordersInfo) throws Exception;
	//根据用户id查询订单(不包含订单明细)
	public List<OrdersInfo> selectOrdersByUser_id(String user_id) throws Exception;
	//查询订单详细信息（包含订单信息、订单明细以及商品信息）
	public OrdersInfo selectOrdersByOrders_id(String orders_id) throws Exception;
	//添加订单
	public Orders insertOrders(String [] cartitem_ids,String user_id,String address_id) throws Exception;
	//修改订单状态
	public int updateOrders(String orders_num) throws Exception;
}
