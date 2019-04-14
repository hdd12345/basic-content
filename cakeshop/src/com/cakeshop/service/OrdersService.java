package com.cakeshop.service;

import java.util.List;

import com.cakeshop.entity.Orders;
import com.cakeshop.entity.OrdersInfo;

public interface OrdersService {
//	//��Ӷ���
//	public int insertOrders(OrdersInfo ordersInfo) throws Exception;
	//�����û�id��ѯ����(������������ϸ)
	public List<OrdersInfo> selectOrdersByUser_id(String user_id) throws Exception;
	//��ѯ������ϸ��Ϣ������������Ϣ��������ϸ�Լ���Ʒ��Ϣ��
	public OrdersInfo selectOrdersByOrders_id(String orders_id) throws Exception;
	//��Ӷ���
	public Orders insertOrders(String [] cartitem_ids,String user_id,String address_id) throws Exception;
	//�޸Ķ���״̬
	public int updateOrders(String orders_num) throws Exception;
}
