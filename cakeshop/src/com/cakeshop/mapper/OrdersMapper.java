package com.cakeshop.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cakeshop.entity.Orders;
import com.cakeshop.entity.OrdersInfo;

@Repository("ordersMapper")
public interface OrdersMapper {
    //根据用户id查询订单
	public List<OrdersInfo> selectOrdersByUser_id(String user_id) throws Exception;
	//根据订单id查询订单及订单明细（关联查询，使用扩展类OrdersInfo封装查询结果数据）
	public OrdersInfo selectOrdersByOrders_id(String orders_id) throws Exception;
	//添加订单
	public int insertOrders(Orders orders) throws Exception;
	//删除订单
	public int deleteOrders(String orders_id) throws Exception;
	//查询当天订单量
	public int selectOrdersCount(String dateStr) throws Exception;
	//修改订单状态
	public int updateState(String orders_num) throws Exception;
}