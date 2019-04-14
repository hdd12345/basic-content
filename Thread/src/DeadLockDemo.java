
public class DeadLockDemo {

	public static void main(String[] args) {
		Thread t1 = new Thread(new MyThread1(true));
		Thread t2 = new Thread(new MyThread1(false));
		t1.start();
		t2.start();
	}

}

class MyThread1 implements Runnable{
	private boolean flag;
	private static Object obj1 = new Object();
	private static Object obj2= new Object();
	public MyThread1(boolean flag){
		this.flag = flag;
	}
	@Override
	public void run() {
		if(flag){
			synchronized (obj1) {
				System.out.println("if���");
				synchronized (obj2) {
					System.out.println("Ƕ��ͬ�������1");
				}
			}
		}else{
			synchronized (obj2) {
				System.out.println("else���");
				synchronized (obj1) {
					System.out.println("Ƕ��ͬ�������2");
				}
			}
		}
	}
	
}