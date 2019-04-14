package executor;

public class MyThread implements Runnable {
	int i = 0;
	
	public MyThread(int i) {
		this.i=i;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"..."+i);
	}

}
