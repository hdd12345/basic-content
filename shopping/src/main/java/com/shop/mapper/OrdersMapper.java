package com.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.shop.entity.Orders;

@Repository("ordersMapper")
public interface OrdersMapper {
	//添加订单
	public int insertOrders(Orders orders) throws Exception;
	//通过用户id查询订单,按时间降序排序（关联查询订单中包含的订单明细）
	public List<Orders> selectOrdersByUser_id(int user_id) throws Exception;
	//通过店铺id查询订单（关联查询订单中包含的订单明细）
	public List<Orders> selectOrdersByShop_id(int shop_id) throws Exception;
	//通过店铺id即订单状态查询订单，按时间升序排序
	public List<Orders> selectOrdersByState(@Param("shop_id") int shop_id,
			@Param("orders_state") String orders_state) throws Exception;
	//修改订单状态
	public int updateOrders_state(@Param("orders_state") String orders_state,
			@Param("orders_id") int orders_id) throws Exception;
	//模糊查询订单(排序规则：1、全匹配，2、头匹配，3、尾匹配，4、中间匹配)
	public List<Orders> selectOrders(@Param("key_word") String key_word,
			@Param("user_id") int user_id) throws Exception;
	//根据日期串查询订单
	public List<Orders> selectOrdersByDate(@Param("date") String date) throws Exception;
}
