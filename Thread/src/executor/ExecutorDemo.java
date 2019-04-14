package executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorDemo {

	public static void main(String[] args) throws InterruptedException {
		//�����޴�С�̳߳أ�����һ���ɻ�����̳߳أ���������������տ��е��߳̽���ʹ�ã����û�п��е��̣߳���ᴴ���µ��̣߳�
		//ExecutorService pool = Executors.newCachedThreadPool();
		
		//ָ�����޵��̳߳أ����ҵ�񳬳��߳��������Ǿ��Ŷӣ�
		//ע���Ŷӵ�ʱ��Ȼ��˭���߳̽�����ֱ���ù���ʹ�ã������̳߳��������£�����ֱ��ȥ���µ��̣߳�
		//ExecutorService pool = Executors.newFixedThreadPool(20);
		
		//�̶���С���̳߳أ�֧�ֶ�ʱ��������ִ��
		//ScheduledExecutorService pool = Executors.newScheduledThreadPool(20);
		
		//���̵߳��̳߳أ���һ���̷߳����쳣�ҵ��󣬻����´���һ���߳�ִ��
		ExecutorService pool = Executors.newSingleThreadExecutor();
		for(int i = 1;i<=10;i++) {
			Thread t = new Thread(new MyThread(i));
			t.setName("mythread-1010");
			pool.execute(t);
			
			//�ڶ�������Ϊ�ȴ��೤ʱ�俪ʼִ�У�����������Ϊ����೤ʱ��ִ��һ�Σ����ĸ�����Ϊʱ�䵥λ
			//pool.scheduleAtFixedRate(t,5000,1000,TimeUnit.MILLISECONDS);
			
			//Thread.sleep(1000);
		}
	}

}
