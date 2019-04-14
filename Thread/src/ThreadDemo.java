
public class ThreadDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread thread = new MyThread();
		thread.setPriority(10);
		thread.start();
		//线程中断
//		thread.interrupt();
		//等待线程死亡
//		thread.join();
		//返回激活的线程数
//		System.out.println(Thread.activeCount());
		
		for(int i=0;i<50;i++){
			System.out.println("主线程："+i);
		}
		//线程优先级
//		System.out.println(thread.getPriority());
//		System.out.println(Thread.currentThread().getPriority());
		//获取线程id
//		System.out.println(thread.getId());
//		System.out.println(Thread.currentThread().getId());
		
	}

}

class MyThread extends Thread{

	@Override
	public void run() {
		for(int i=0;i<50;i++){
			System.out.println("子线程："+i);
			//Thread.yield(); 调用此方法暂停线程后什么时候继续执行由线程调度器来决定。
		}
	}
	
}
