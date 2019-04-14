package com.hdd.test;

import static org.junit.Assert.*;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hdd.entity.User;
import com.hdd.mapper.UserMapper;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:spring/applicationContext.xml")
public class JedisTest {
	
	@Resource(name="jedisPool")
	private JedisPool pool;
	
	private Jedis jedis;
	
	@Resource(name="userMapper")
	private UserMapper userMapper;
	
	@Before
	public void setUp() throws Exception {
		jedis = pool.getResource();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		System.out.println(jedis.get("piguye"));
	}
	
	/**
	 * redis中不存在时，去mysql查询，并放入redis中
	 * @throws Exception
	 */
	@Test
	public void hashTest() throws Exception {
//		User user = userMapper.selectUserById(1);
//		Map<String,String> map = BeanUtils.describe(user);
//		System.out.println(map);
//		jedis.hmset(user.getId()+"",map);
		User user = new User();
		//System.out.println(jedis.exists("11"));
		if(jedis.exists("11")) {
			Map<String,String> map = jedis.hgetAll("11");
			BeanUtils.populate(user,map);
		}else {
			user = userMapper.selectUserById(11);
			Map<String,String> map = BeanUtils.describe(user);
			jedis.hmset(user.getId()+"",map);
		}
		System.out.println(user);
	}

}
