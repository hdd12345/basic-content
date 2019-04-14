package com.cakeshop.service;

import java.util.List;

import com.cakeshop.entity.Cartitem;
import com.cakeshop.entity.CartitemInfo;

public interface CartService {
	//�����û�id��ѯ���ﳵ��ϸ��������Ʒ��Ϣ��
	public List<CartitemInfo> selectCartitemByUser_id(String user_id) throws Exception;
	//����ɾ�����ﳵ��ϸ
	public int deleteCartitem(String [] cartitem_ids) throws Exception;
	//��ӹ��ﳵ��ϸ
	public int insertCartitem(Cartitem cartitem,String user_id) throws Exception;
	//�޸Ĺ��ﳵ��ϸ����Ҫ�����޸�����
	public int updateCartitem(Cartitem cartitem) throws Exception;
}
