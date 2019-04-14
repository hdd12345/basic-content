package threadlocaltest;

public class ThreadLocalDemo {
	ThreadLocal<User> tl = new ThreadLocal<>(); 
	{
		tl.set(new User());
	}
	public static void main(String[] args) {
		ThreadLocalDemo test = new ThreadLocalDemo();		
		User user = test.tl.get();
		System.out.println(user);
		user.setAge(12);
		user.setUsername("xiaoming");
		test.tl.set(user);
		System.out.println(test.tl.get());
		
		Thread thread1 = new Thread(){
            public void run() {
            	test.tl.set(new User());
                System.out.println(test.tl.get());
            };
        };
		thread1.start();
		
	}
	
	

}
