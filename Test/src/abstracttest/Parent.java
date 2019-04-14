package abstracttest;

public class Parent {
	
	
	
	Parent() {
		System.out.println("父类构造器");
	}
	
	public Class hello() {
		return this.getClass();
	}
	
	{
		System.out.println("父类初始化块");
	}
	
	static {
		System.out.println("父类静态初始化块");
	}
	
	Test test = new Test();
}
