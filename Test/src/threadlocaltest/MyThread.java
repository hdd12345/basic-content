package threadlocaltest;

public class MyThread extends Thread {
	ThreadLocal<User> tl = null;
	MyThread(ThreadLocal<User> tl){
		this.tl = tl;
//		System.out.println(this.tl.get());
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
//		User user1 = tl.get();
		System.out.println(tl);
	}
}
