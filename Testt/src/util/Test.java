package util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.event.TransactionalEventListener;

import entity.User;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac= new ClassPathXmlApplicationContext("applicationContext.xml");
		User user = (User) ac.getBean(User.class);
		System.out.println(user.getUsername());
	}
	public void findUserById() {
		
	}

}
