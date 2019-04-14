package com.hdd.test;

import static org.junit.Assert.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hdd.entity.Phone;
import com.hdd.entity.User;
import com.hdd.util.HibernateUtil;

public class TestManyToOne {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void insert01() {
		Session session = null;
		try {
			 session = HibernateUtil.openSession();
			 session.beginTransaction();
			 User user = new User();
			 user.setUsername("bbb");
			 user.setPassword("222");
			 session.save(user);
			 Phone phone = new Phone();
			 phone.setName("小米");
			 phone.setPhonesize("note3");
			 phone.setUser(user);
			 session.save(phone);
			 session.getTransaction().commit();
		}catch (HibernateException e) {
			e.printStackTrace();
			if(session!=null)session.getTransaction().rollback();
		}finally {
			if(session!=null)HibernateUtil.close(session);
		}
	}
	
	@Test
	public void insert02() {
		Session session = null;
		try {
			 session = HibernateUtil.openSession();
			 session.beginTransaction();	 
			 Phone phone = new Phone();
			 phone.setName("小米");
			 phone.setPhonesize("note3"); 
			 session.save(phone);
			 User user = new User();
			 user.setUsername("bbb");
			 user.setPassword("222");
			 session.save(user);
			 phone.setUser(user);
			 session.getTransaction().commit();
		}catch (HibernateException e) {
			e.printStackTrace();
			if(session!=null)session.getTransaction().rollback();
		}finally {
			if(session!=null)HibernateUtil.close(session);
		}
	}
	
	@Test
	public void insert03() {
		Session session = null;
		try {
			 session = HibernateUtil.openSession();
			 session.beginTransaction();	 
			 Phone phone = new Phone();
			 phone.setName("小米");
			 phone.setPhonesize("note3"); 
			 session.save(phone);
			 User user = new User();
			 user.setUsername("bbb");
			 user.setPassword("222");
			 phone.setUser(user);
			 session.getTransaction().commit();
		}catch (HibernateException e) {
			e.printStackTrace();
			if(session!=null)session.getTransaction().rollback();
		}finally {
			if(session!=null)HibernateUtil.close(session);
		}
	}
	
	/**
	 * 关联查询load懒加载
	 */
	@Test
	public void select01() {
		Session session = null;
		try {
			 session = HibernateUtil.openSession();
			 session.beginTransaction();	 
			 Phone phone = (Phone)session.load(Phone.class,1);
			 System.out.println(phone.getName());
			 System.out.println(phone.getUser());
			 System.out.println(phone);
			 session.getTransaction().commit();
		}catch (HibernateException e) {
			e.printStackTrace();
			if(session!=null)session.getTransaction().rollback();
		}finally {
			if(session!=null)HibernateUtil.close(session);
		}
	}

}
