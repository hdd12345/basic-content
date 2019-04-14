package entity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class People {
	private User user = new User();
	
	@Bean(name="user")
	public User getUser() {
		user.setUsername("hhh");
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
