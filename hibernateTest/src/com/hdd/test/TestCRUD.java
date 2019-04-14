package com.hdd.test;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hdd.entity.User;
import com.hdd.util.HibernateUtil;

public class TestCRUD {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsert() {
		Session session = null;
		try {
			session = HibernateUtil.openSession();
			session.beginTransaction();
			
			User user = new User();
			user.setUsername("abcd");
			user.setPassword("1234");
			session.save(user);
//			user.setUsername("aaaa");
//			user.setPassword("1111");
			session.getTransaction().commit();
		}catch (HibernateException e) {
			if(session!=null)session.getTransaction().rollback();
		}finally {
			HibernateUtil.close(session);
		}
	}
	
//	@Test
//	public void testDelete() {
//		Session session = null;
//		try {
//			session = HibernateUtil.openSession();
//			session.beginTransaction();
//			User user = new User();
//			user.setId(3);
//			session.delete(user);
//			session.getTransaction().commit();
//		}catch (HibernateException e) {
//			e.printStackTrace();
//			if(session!=null)session.getTransaction().rollback();
//		}finally {
//			HibernateUtil.close(session);
//		}
//	}
	
	@Test
	public void testUpdate() {
		Session session = null;
		try {
			session = HibernateUtil.openSession();
			session.beginTransaction();
			
			User user = new User();
			user.setId(2);
			user.setUsername("abcdef");
			user.setPassword("123456");
			session.update(user);
//			user.setPassword("111");
			session.getTransaction().commit();
		}catch (HibernateException e) {
			e.printStackTrace();
			if(session!=null)session.getTransaction().rollback();
		}finally {
			HibernateUtil.close(session);
		}
	}
	
	@Test
	public void testSelect() {
		Session session = null;
		try {
			session = HibernateUtil.openSession();
			System.out.println(session.load(User.class,1));
		}catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			HibernateUtil.close(session);
		}
	}
	
	@Test
	public void testList() {
		Session session = null;
		try {
			session = HibernateUtil.openSession();
			//字符串中User为java类型，而非数据库表
			List<User> list = session.createQuery("from User").list();
			for(User user:list) {
				System.out.println(user);
			}
		}catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			HibernateUtil.close(session);
		}
	}
	
	/**
	 * 分页
	 */
	@Test
	public void testPage() {
		Session session = null;
		try {
			session = HibernateUtil.openSession();
			//字符串中User为java类型，而非数据库表
			List<User> list = session.createQuery("from User")
					.setFirstResult(0).setMaxResults(2).list();
			for(User user:list) {
				System.out.println(user);
			}
		}catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			HibernateUtil.close(session);
		}
	}
	
	@Test
	public void testCache() {
		Session session = null;
		try {
			session = HibernateUtil.openSession();
			List<User> list = session.createQuery("from User")
					.setFirstResult(0).setMaxResults(2).list();
		}catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			HibernateUtil.close(session);
		}
		try {
			session = HibernateUtil.openSession();
			List<User> list = session.createQuery("from User")
					.setFirstResult(0).setMaxResults(2).list();
			for(User user:list) {
				System.out.println(user);
			}
		}catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			HibernateUtil.close(session);
		}
	}

}
