package com.cakeshop.test;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cakeshop.entity.Address;
import com.cakeshop.mapper.AddressMapper;
import com.cakeshop.mapper.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class AddressMapperTest {
	@Resource(name = "addressMapper")
	public AddressMapper addressMapper;

	@Test
	public void testSelectAddressById() throws Exception {
		/*
		 * Address address = new Address();
		 * System.out.println(addressMapper.selectAddressById("1"));
		 */
	}

	@Test
	public void testDeleteAddess() throws Exception {
		/*
		 * Address address = new Address();
		 * System.out.println(addressMapper.deleteAddess("qwewq"));
		 */
	}

	@Test
	public void testInsertAddess() throws Exception {
		/*
		 * Address address = new Address(); address.setAddress_content("wqejq");
		 * address.setAddress_id("qwewq"); address.setName("qweqwe");
		 * address.setPostcode("qweq"); address.setTelephone("123321");
		 * address.setUser_id("1");
		 * System.out.println(addressMapper.insertAddess(address));
		 */
	}

	@Test
	public void testUpdateAddress() throws Exception {
		/*
		 * Address address = new Address();
		 * address.setAddress_content("ewrwer"); address.setAddress_id("qwewq");
		 * address.setName("qwwerewrwe"); address.setPostcode("q1232132");
		 * address.setTelephone("1265757"); address.setUser_id("1");
		 * System.out.println(addressMapper.updateAddress(address));
		 */
	}

}
