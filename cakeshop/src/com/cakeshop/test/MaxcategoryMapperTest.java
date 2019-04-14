package com.cakeshop.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cakeshop.entity.Maxcategory;
import com.cakeshop.mapper.AddressMapper;
import com.cakeshop.mapper.MaxcategoryMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class MaxcategoryMapperTest {
	@Resource(name = "maxcategoryMapper")
	public MaxcategoryMapper maxcategoryMapper;

	@Test
	public void testSelectMaxcategory() throws Exception {
		List<Maxcategory> list = maxcategoryMapper.selectMaxcategory();
		for (Maxcategory m : list) {
			System.out.println(m);
		}

	}
	
	@Test
	public void testSelectCategory() throws Exception{
		List<Maxcategory> list = maxcategoryMapper.selectCategory();
		for(Maxcategory m:list){
			System.out.println(m);
		}
	}

}
