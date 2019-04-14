package com.shop.test.mapper;

import java.util.List;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shop.entity.Address;
import com.shop.mapper.AddressMapper;

public class AddressMapperTest {
	private ApplicationContext applicationContext;
	private AddressMapper addressMapper;
	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		addressMapper = (AddressMapper)applicationContext.getBean("addressMapper");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsertAddress() throws Exception {
		Address address = new Address();
		address.setName("翠花2");
		address.setPhone_num("13838380438");
		address.setPostcode("430056");
		address.setAddress_content("湖北省武汉市蔡甸区东风大道武汉商学院");
		address.setUser_id(3);
		System.out.println(addressMapper.insertAddress(address));
	}

	@Test
	public void testDeleteAddressById() throws Exception {
//		System.out.println(addressMapper.deleteAddressById(5));
	}

	@Test
	public void testUpdateAddress() throws Exception {
		Address address = new Address();
		address.setAddress_id(4);
		address.setName("翠花4");
		address.setPhone_num("110110110");
		address.setAddress_content("湖北省武汉市蔡甸区东风大道武汉商学院");
		address.setPostcode("430000");
		address.setUser_id(4);
		System.out.println(addressMapper.updateAddress(address));
	}

	@Test
	public void testSelectAddressByUser_id() throws Exception {
		List<Address> list = addressMapper.selectAddressByUser_id(3);
		for(Address address:list){
			System.out.println(address);
		}
	}

	@Test
	public void testSelectAllProvince() throws Exception {
		List<String> list = addressMapper.selectAllProvince();
		for(String str:list) {
			System.out.println(str);
		}
	}

	@Test
	public void testSelectCityByProvince() throws Exception {
		List<String> list = addressMapper.selectCityByProvince("湖北省");
		for(String str:list) {
			System.out.println(str);
		}
	}

	@Test
	public void testSelectAreaByCity() throws Exception {
		List<String> list = addressMapper.selectCityByProvince("武汉市");
		for(String str:list) {
			System.out.println(str);
		}
	}

}
