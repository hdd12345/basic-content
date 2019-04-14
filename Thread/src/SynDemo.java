
public class SynDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Res r = new Res();
		new Thread(new Input1(r)).start();
		new Thread(new Output1(r)).start();
	}
}
	
	class Input1 implements Runnable{
		private Res r;
		public Input1(Res r){
			this.r=r;
		}
		@Override
		public void run() {
			int x =0;
			while(true){
				synchronized (r) {
						if(r.flag){
							try {
								r.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						if(x%2==0){
							r.setName("Jack");
							r.setSex("man");
						}else{
							r.setName("Rose");
							r.setSex("Ů");
						}
						x++;
						r.flag=true;
						r.notify();
				}		
				
			}	
		}		
	}
	

	
	class Output1 implements Runnable{
		private Res r;
		public Output1(Res r){
			this.r=r;
		}
		@Override
		public void run() {
			while(true){
				synchronized (r) {
					if(!r.flag){
						try {
							r.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println(r.getName()+"-----"+r.getSex());
					r.flag=false;
					r.notify();
				}
			}
		}	
	}
	
	class Res{
		private String name;
		private String sex;
		public boolean flag = false;
		
//		public Res(String name,String sex){
//			this.name=name;
//			this.sex=sex;
//		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		
	}


