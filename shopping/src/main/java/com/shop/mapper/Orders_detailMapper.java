package com.shop.mapper;

import org.springframework.stereotype.Repository;

import com.shop.entity.Orders_detail;

@Repository("orders_detailMapper")
public interface Orders_detailMapper {
	//添加订单明细
	public int insertOrders_detail(Orders_detail orders_detail) throws Exception;
}
