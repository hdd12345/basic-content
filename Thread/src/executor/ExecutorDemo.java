package executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorDemo {

	public static void main(String[] args) throws InterruptedException {
		//无上限大小线程池（创建一个可缓存的线程池，若有需求它会回收空闲的线程进行使用，如果没有空闲的线程，则会创建新的线程）
		//ExecutorService pool = Executors.newCachedThreadPool();
		
		//指定上限的线程池（如果业务超出线程数量，那就排队；
		//注意排队的时候然后谁的线程结束了直接拿过来使用，但是线程充足的情况下，它会直接去拿新的线程）
		//ExecutorService pool = Executors.newFixedThreadPool(20);
		
		//固定大小的线程池，支持定时和周期性执行
		//ScheduledExecutorService pool = Executors.newScheduledThreadPool(20);
		
		//单线程的线程池，当一个线程发生异常挂掉后，会重新创建一个线程执行
		ExecutorService pool = Executors.newSingleThreadExecutor();
		for(int i = 1;i<=10;i++) {
			Thread t = new Thread(new MyThread(i));
			t.setName("mythread-1010");
			pool.execute(t);
			
			//第二个参数为等待多长时间开始执行，第三个参数为间隔多长时间执行一次，第四个参数为时间单位
			//pool.scheduleAtFixedRate(t,5000,1000,TimeUnit.MILLISECONDS);
			
			//Thread.sleep(1000);
		}
	}

}
