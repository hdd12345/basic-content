package abstracttest;

public class Parent {
	
	
	
	Parent() {
		System.out.println("���๹����");
	}
	
	public Class hello() {
		return this.getClass();
	}
	
	{
		System.out.println("�����ʼ����");
	}
	
	static {
		System.out.println("���ྲ̬��ʼ����");
	}
	
	Test test = new Test();
}
