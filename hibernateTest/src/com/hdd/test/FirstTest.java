package com.hdd.test;

import static org.junit.Assert.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hdd.entity.User;

public class FirstTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Configuration cfg = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(cfg.getProperties()).buildServiceRegistry();
		//创建SessionFactory
		SessionFactory sessionFactory = cfg.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		try {
			//开启事务
			session.beginTransaction();
			User user = new User();
			user.setUsername("abc");
			user.setPassword("123");
			session.save(user);
			//关闭事务
			session.getTransaction().commit();
		}catch (HibernateException e) {
			e.printStackTrace();
			if(session!=null)session.getTransaction().rollback();
		}finally {
			if(session!=null)session.close();
		}
		
	}

}
