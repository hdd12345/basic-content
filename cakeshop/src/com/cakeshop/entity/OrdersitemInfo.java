package com.cakeshop.entity;

/**
 * 扩展类（用于关联查询）
 * @author Administrator
 *
 */
public class OrdersitemInfo extends Ordersitem {
	private String ordersitem_id;

    private String orders_id;

    private String goods_id;

    private Integer quantity;

    private Double total_price;
    //以下为扩展属性
    private Goods goods;
    
	public String getOrdersitem_id() {
		return ordersitem_id;
	}
	public void setOrdersitem_id(String ordersitem_id) {
		this.ordersitem_id = ordersitem_id;
	}
	public String getOrders_id() {
		return orders_id;
	}
	public void setOrders_id(String orders_id) {
		this.orders_id = orders_id;
	}
	public String getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(Double total_price) {
		this.total_price = total_price;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
    
    
}
