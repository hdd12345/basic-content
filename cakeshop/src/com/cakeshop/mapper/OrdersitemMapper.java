package com.cakeshop.mapper;

import org.springframework.stereotype.Repository;

import com.cakeshop.entity.Ordersitem;

@Repository("ordersitemMapper")
public interface OrdersitemMapper {
	//添加订单项
	public int insertOrdersitem(Ordersitem ordersitem) throws Exception;
    //根据订单项id查询
	public Ordersitem selectById(String ordersitem_id) throws Exception;
	//删除订单项
	public int deleteOrdersitem(String ordersitem_id) throws Exception;
}