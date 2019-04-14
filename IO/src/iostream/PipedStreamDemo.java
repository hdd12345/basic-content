package iostream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.Serializable;
/**
 * 管道流：用于线程之间传递数据
 * @author Administrator
 *
 */
public class PipedStreamDemo {

	public static void main(String[] args) throws IOException {
		PipedInputStream in = new PipedInputStream();
		PipedOutputStream out = new PipedOutputStream();
		in.connect(out);
		Read r = new Read(in);
		Write w = new Write(out);
		new Thread(r).start();
		new Thread(w).start();
	}

}

class Read implements Runnable{
		PipedInputStream in;
		public Read(PipedInputStream in){
			this.in=in;
		}
		@Override
		public void run(){
			byte[] b = new byte[1024];
			try {
				int num = in.read(b);
				System.out.println(new String(b,0,num));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}

class Write implements Runnable{
	PipedOutputStream out;
	public Write(PipedOutputStream out){
		this.out=out;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			out.write("哈哈哈哈".getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
