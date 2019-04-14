import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class Task implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for(int i=0;i<50;i++){
			sum+=i;
			System.out.println(sum);
		}
		Thread.sleep(5000);
		return sum;
	}
	
}
public class CallableDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		FutureTask<Integer> ft = new FutureTask<Integer>(new Task());
		Thread t = new Thread(ft);
		t.start();
		System.out.println("��ȡ����ֵ��"+ft.get());
		//���ȴ�5�룬����5��δִ�����޷����ؽ������java.util.concurrent.TimeoutException
		//System.out.println("��ȡ����ֵ��"+ft.get(5000,TimeUnit.MILLISECONDS));
	}

}
