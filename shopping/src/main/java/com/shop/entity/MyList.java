package com.shop.entity;

import java.util.List;

/**
 * 扩展实体类，用于@RequestBody映射List类型参数
 * @author Administrator
 *
 */
public class MyList {
	private List<Orders> ordersList;

	public List<Orders> getOrdersList() {
		return ordersList;
	}
	public void setOrdersList(List<Orders> ordersList) {
		this.ordersList = ordersList;
	}
}
