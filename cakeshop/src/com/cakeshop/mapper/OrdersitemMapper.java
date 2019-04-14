package com.cakeshop.mapper;

import org.springframework.stereotype.Repository;

import com.cakeshop.entity.Ordersitem;

@Repository("ordersitemMapper")
public interface OrdersitemMapper {
	//��Ӷ�����
	public int insertOrdersitem(Ordersitem ordersitem) throws Exception;
    //���ݶ�����id��ѯ
	public Ordersitem selectById(String ordersitem_id) throws Exception;
	//ɾ��������
	public int deleteOrdersitem(String ordersitem_id) throws Exception;
}