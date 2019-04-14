package abstracttest;
public class Son extends Parent {
	
	
	
	public Son (){
		System.out.println("子类构造器");
	}
	
	{
		System.out.println("子类初始化块");
	}
	
	static {
		System.out.println("子类静态初始化块");
	}
	
	Test test = new Test();
}
