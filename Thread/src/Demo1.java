
public class Demo1 {
	public static void main(String [] args) {
		Resource resource = new Resource();
		Input input = new Input(resource);
		Output output = new Output(resource);
		Thread t1 = new Thread(input);
		Thread t2 = new Thread(input);
		Thread t3 = new Thread(output);
		Thread t4 = new Thread(output);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
//		for(int i = 0;i<=100;i++){
//			System.out.println(resource.id);
//		}
	}

}
class Resource{
	private String name ;
	public int id = 1;
	private boolean flag = false;

	public synchronized void set(String name) {
			this.name=name;
	
			
				while(flag) 
				try {
					this.wait();
					
				} catch (InterruptedException e) {
				
					e.printStackTrace();
				}
				this.name = name+"----------"+id++;
				//id++;
				System.out.println(Thread.currentThread().getName()+"生產"+this.name);
				//System.out.println(Thread.currentThread().getName()+"生產"+this.name+id++);
				flag = true;
				this.notifyAll();
			
	}
	public synchronized void out() {
	while(!flag) 
		try {
			this.wait();
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"消費"+this.name);
		flag = false;
		this.notifyAll();
		}
	
			
		
	}

class Input implements Runnable{
	private Resource resource;
	public Input(Resource resource) {
	this.resource=resource;
}
	@Override
	public void run() {
		
//		while(true) {
//			resource.set("商品");
//		}
		for(int i =0;i<100;i++){
			resource.set("商品");
		}
	}
}
	
class Output implements Runnable{
		private Resource resource;
		public Output(Resource resource) {
			this.resource=resource;
		}
		@Override
		public void run() {
//		while(true) {
//			resource.out();
//		}
			for(int i =0;i<100;i++){
				resource.out();
			}
			
		}
		
	}
	
