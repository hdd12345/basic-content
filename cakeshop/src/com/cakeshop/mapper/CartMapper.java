package com.cakeshop.mapper;

import com.cakeshop.entity.Cart;

public interface CartMapper {
	//��ӹ��ﳵ
	public int insertCart(Cart cart) throws Exception;
	//�����û�id��ѯ���ﳵ
	public Cart selectCartByUser_id(String user_id) throws Exception;
	//�����û�id��ѯ���ﳵ�����ﳵ��ϸ��������ѯ���������ﳵ��Ϣ�����ﳵ��ϸ��Ϣ����Ʒ��Ϣ��
}