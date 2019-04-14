package com.hdd.test;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hdd.entity.Phone;
import com.hdd.entity.PhoneDto;
import com.hdd.entity.User;
import com.hdd.util.HibernateUtil;

public class HQLTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test01() {
		Session session = null;
		try {
			session = HibernateUtil.openSession();
//			User user = (User)session.createQuery("select user from User user where id=1").uniqueResult();
//			User user = (User)session.createQuery("select user from User user where id=?")
//					.setParameter(0,1).uniqueResult();
			User user = (User)session.createQuery("select user from User user where id=:id")
					.setParameter("id",1).uniqueResult();
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			HibernateUtil.close(session);
		}
	}
	
	/**
	 * 查询count
	 */
	@Test
	public void test02() {
		Session session = null;
		try {
			session = HibernateUtil.openSession();
			//返回long类型
			long count = (long)session.createQuery("select count(*) from User user").uniqueResult();
			System.out.println(count);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			HibernateUtil.close(session);
		}
	}
	
	/**
	 * 模糊查询
	 */
	@Test
	public void test03() {
		Session session = null;
		try {
			session = HibernateUtil.openSession();
//			List<User> list = session.createQuery("select user from User user where username like ?")
//					.setParameter(0,"%abc%").list();
			List<User> list = session.createQuery("select user from User user where username like :username")
					.setParameter("username","%abc%").list();
			for(User user:list) {
				System.out.println(user.getUsername());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			HibernateUtil.close(session);
		}
	}
	
	/**
	 * 多条件组合查询，别名参数必须放在占位符参数前面
	 */
	@Test
	public void test04() {
		Session session = null;
		try {
			session = HibernateUtil.openSession();
			List<User> list = session.createQuery("select user from User user where id=? and username like :username")
					.setParameter(0,1).setParameter("username","%abc%").list();
			for(User user:list) {
				System.out.println(user.getUsername());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			HibernateUtil.close(session);
		}
	}
	
	/**
	 * 传入数组类型参数
	 */
	@Test
	public void test05() {
		Session session = null;
		try {
			session = HibernateUtil.openSession();
			List<Phone> list = session.createQuery("select phone from Phone phone where phone.user.id in (:userids) ")
					.setParameterList("userids",new Integer[] {1,2,10}).list();
			for(Phone phone:list) {
				System.out.println(phone.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			HibernateUtil.close(session);
		}
	}
	
	/**
	 * 连接查询：可以使用对象导航实现，但是基于Cross Join，效率不高，一般使用join实现(默认为inner join)
	 * 因为对象之间已经建立关系，所以不用写连接条件
	 */
	@Test
	public void test06() {
		Session session = null;
		try {
			session = HibernateUtil.openSession();
			List<PhoneDto> list = session.createQuery("select new com.hdd.entity.PhoneDto"
					+ "(phone.name as pname,user.username as username)"
					+ " from Phone phone join phone.user user")
					.list();
			for(PhoneDto phoneDto:list) {
				System.out.println(phoneDto.getPname()+","+phoneDto.getUsername());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			HibernateUtil.close(session);
		}
	}
	
	/**
	 * 投影查询。返回Object数组
	 */
	@Test
	public void test07() {
		Session session = null;
		try {
			session = HibernateUtil.openSession();
			List<Object[]> list = session.createQuery("select phone.name,phone.user.username from Phone phone where phone.user.id=10")
					.list();
			for(Object[] obj:list) {
				System.out.println(obj[0]+","+obj[1]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			HibernateUtil.close(session);
		}
	}

}
