import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Test implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"haha");
	}
	
}
public class ExecutorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService es = Executors.newFixedThreadPool(5);
		for(int i = 0;i<6;i++){
			es.execute(new Test());
		}
		es.shutdown();//ÓÐÐò¹Ø±Õ
	}

}
