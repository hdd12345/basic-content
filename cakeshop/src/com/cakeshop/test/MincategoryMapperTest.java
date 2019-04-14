package com.cakeshop.test;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cakeshop.mapper.MaxcategoryMapper;
import com.cakeshop.mapper.MincategoryMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class MincategoryMapperTest {
	@Resource(name = "mincategoryMapper")
	public MincategoryMapper mincategoryMapper;

	@Test
	public void testSelectMincategory() throws Exception {
		System.out.println(mincategoryMapper.selectMincategory("1"));
	}

}
