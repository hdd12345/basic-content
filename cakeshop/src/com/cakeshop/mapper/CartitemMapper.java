package com.cakeshop.mapper;

import java.util.List;

import com.cakeshop.entity.Cartitem;
import com.cakeshop.entity.CartitemInfo;

public interface CartitemMapper {
    //���ݹ��ﳵid��ѯ���ﳵ��ϸ��������ѯ��������а������ﳵ��ϸ����Ʒ��Ϣ��
	public List<CartitemInfo> selectByCart_id(String cart_id) throws Exception;
	//ɾ�����ﳵ��ϸ����������
	public int deleteCartitems(String [] cartitem_ids) throws Exception;
	//��ӹ��ﳵ��ϸ
	public int insertCartitem(Cartitem cartitem) throws Exception;
	//�޸Ĺ��ﳵ��ϸ
	public int updateCartitem(Cartitem cartitem) throws Exception;
	//���ݹ��ﳵ��ϸid��ѯ���ﳵ��ϸ
	public CartitemInfo selectByCartitem_id(String cartitem_id) throws Exception;
}