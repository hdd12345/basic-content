
public class ThreadDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread thread = new MyThread();
		thread.setPriority(10);
		thread.start();
		//�߳��ж�
//		thread.interrupt();
		//�ȴ��߳�����
//		thread.join();
		//���ؼ�����߳���
//		System.out.println(Thread.activeCount());
		
		for(int i=0;i<50;i++){
			System.out.println("���̣߳�"+i);
		}
		//�߳����ȼ�
//		System.out.println(thread.getPriority());
//		System.out.println(Thread.currentThread().getPriority());
		//��ȡ�߳�id
//		System.out.println(thread.getId());
//		System.out.println(Thread.currentThread().getId());
		
	}

}

class MyThread extends Thread{

	@Override
	public void run() {
		for(int i=0;i<50;i++){
			System.out.println("���̣߳�"+i);
			//Thread.yield(); ���ô˷�����ͣ�̺߳�ʲôʱ�����ִ�����̵߳�������������
		}
	}
	
}
