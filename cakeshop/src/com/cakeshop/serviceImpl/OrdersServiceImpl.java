package com.cakeshop.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cakeshop.entity.CartitemInfo;
import com.cakeshop.entity.Orders;
import com.cakeshop.entity.OrdersInfo;
import com.cakeshop.entity.Ordersitem;
import com.cakeshop.entity.OrdersitemInfo;
import com.cakeshop.mapper.CartitemMapper;
import com.cakeshop.mapper.OrdersMapper;
import com.cakeshop.mapper.OrdersitemMapper;
import com.cakeshop.service.OrdersService;
import com.cakeshop.util.CommonUtil;

@Service("ordersServiceImpl")
public class OrdersServiceImpl implements OrdersService {
	
	@Resource(name="ordersMapper")
	OrdersMapper ordersMapper;
	@Resource(name="ordersitemMapper")
	OrdersitemMapper ordersitemMapper;
	@Resource(name="cartitemMapper")
	CartitemMapper cartitemMapper;
	

//	@Override
//	public int insertOrders(OrdersInfo ordersInfo) throws Exception {
//		int count =0;//���ڼ�¼�������ݿ��¼������
//		Orders orders = new Orders();
//		orders.setOrders_id(UUID.randomUUID().toString().replace("-",""));
//		orders.setAddress_id(ordersInfo.getAddress_id());
//		orders.setOrders_time(new Date());
//		orders.setOrders_total_price(ordersInfo.getOrders_total_price());
//		orders.setUser_id(ordersInfo.getUser_id());
//		//���ɶ�����,����������+��λ�����+���충����
//		String date = CommonUtil.dateFormat("YYYYMMdd");
//		int ordersCount = ordersMapper.selectOrdersCount(date)+1;
//		String orders_num = date+CommonUtil.getRandomNum(3)+ordersCount;
//		orders.setOrders_num(orders_num);
//		//��Ӷ���
//		count+=ordersMapper.insertOrders(orders);
//		//��Ӷ�����
//		List<OrdersitemInfo> list = ordersInfo.getList();
//		for(OrdersitemInfo osi:list){
//			Ordersitem ordersitem = new Ordersitem();
//			ordersitem.setOrdersitem_id(UUID.randomUUID().toString().replace("-",""));
//			ordersitem.setOrders_id(orders.getOrders_id());
//			ordersitem.setGoods_id(osi.getGoods_id());
//			ordersitem.setQuantity(osi.getQuantity());
//			ordersitem.setTotal_price(osi.getTotal_price());
//			count+=ordersitemMapper.insertOrdersitem(ordersitem);
//		}
//		return count;
//	}
	
	/**
	 * �����û�id��ѯ����
	 */
	@Override
	public List<OrdersInfo> selectOrdersByUser_id(String user_id) throws Exception {
		return ordersMapper.selectOrdersByUser_id(user_id);
	}
	
	/**
	 * ���ݶ���id��ѯ������������ѯ��
	 */
	@Override
	public OrdersInfo selectOrdersByOrders_id(String orders_id) throws Exception {
		return ordersMapper.selectOrdersByOrders_id(orders_id);
	}
	
	/**
	 * ��Ӷ���
	 */
	@Override
	public Orders insertOrders(String[] cartitem_ids,String user_id,String address_id) throws Exception {
		int count = 0;
		List<Ordersitem> list = new ArrayList<>();
		double orders_total_price = 0;//�����ܼ�
		for(String cartitem_id:cartitem_ids){
			Ordersitem ordersitem = new Ordersitem();
			CartitemInfo cartitemInfo = cartitemMapper.selectByCartitem_id(cartitem_id);
			ordersitem.setGoods_id(cartitemInfo.getGoods_id());
			ordersitem.setQuantity(cartitemInfo.getQuantity());
			//�������ܼ�=����*��Ʒ����
			double total_price = cartitemInfo.getQuantity()*cartitemInfo.getGoods().getGprice();
			ordersitem.setTotal_price(total_price);
			ordersitem.setOrdersitem_id(UUID.randomUUID().toString().replace("-",""));
			list.add(ordersitem);//��ʱ�����ȱ�ٶ���id����
			orders_total_price+=total_price;//�ۼӶ����ܼ�
		}
		Orders orders = new Orders();
		orders.setOrders_id(UUID.randomUUID().toString().replace("-",""));
		orders.setOrders_total_price(orders_total_price);
		orders.setUser_id(user_id);
		orders.setOrders_time(new Date());
		orders.setAddress_id(address_id);
		//���ɶ�����,����������+��λ�����+���충����
		String date = CommonUtil.dateFormat("YYYYMMdd");
		int ordersCount = ordersMapper.selectOrdersCount(date)+1;
		String orders_num = date+CommonUtil.getRandomNum(3)+ordersCount;
		orders.setOrders_num(orders_num);
		//��Ӷ���
		count+=ordersMapper.insertOrders(orders);
		//��Ӷ�����
		for(Ordersitem os:list){
			os.setOrders_id(orders.getOrders_id());
			count+=ordersitemMapper.insertOrdersitem(os);
		}
		cartitemMapper.deleteCartitems(cartitem_ids);//ɾ�����ﳵ��ϸ
		return orders;
	}
	
	/**
	 * �޸Ķ���״̬
	 */
	@Override
	public int updateOrders(String orders_num) throws Exception {
		return ordersMapper.updateState(orders_num);
	}

}
