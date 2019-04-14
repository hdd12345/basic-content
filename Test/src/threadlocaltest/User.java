package threadlocaltest;

public class User implements Comparable<User> {
	private String username;
	
	private int age;
	
	public User() {
		
	}
	
	public User(String username,int age) {
		this.username = username;
		this.age = age;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		return this.username.hashCode()+age*10;
	}

	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		if(obj instanceof User) {
			User user = (User)obj;
			return this.username.equals(user.getUsername())&&this.age==user.getAge();
		}
		return false;
	}

	@Override
	public int compareTo(User user) {
		if(this.age>user.getAge())
			return 1;
		if(this.age<user.getAge())
			return -1;
		return this.username.compareTo(user.getUsername());
	}

	@Override
	public String toString() {
		return "["+this.username+","+this.age+"]";
	}
	
	
	
}
