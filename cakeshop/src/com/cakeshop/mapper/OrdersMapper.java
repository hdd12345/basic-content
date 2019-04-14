package com.cakeshop.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cakeshop.entity.Orders;
import com.cakeshop.entity.OrdersInfo;

@Repository("ordersMapper")
public interface OrdersMapper {
    //�����û�id��ѯ����
	public List<OrdersInfo> selectOrdersByUser_id(String user_id) throws Exception;
	//���ݶ���id��ѯ������������ϸ��������ѯ��ʹ����չ��OrdersInfo��װ��ѯ������ݣ�
	public OrdersInfo selectOrdersByOrders_id(String orders_id) throws Exception;
	//��Ӷ���
	public int insertOrders(Orders orders) throws Exception;
	//ɾ������
	public int deleteOrders(String orders_id) throws Exception;
	//��ѯ���충����
	public int selectOrdersCount(String dateStr) throws Exception;
	//�޸Ķ���״̬
	public int updateState(String orders_num) throws Exception;
}