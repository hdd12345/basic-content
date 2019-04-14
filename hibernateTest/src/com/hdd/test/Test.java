package com.hdd.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.hdd.entity.User;
import com.hdd.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
