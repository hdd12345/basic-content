package single;

/**
 * ����ģʽʵ�ַ�ʽ2����̬�ڲ���
 * @author Administrator
 *
 */
public class SingleBuilder {
	private final static Single2 single = new Single2();
	
	
	private static class Single2 extends Single{
		
	}
	
	public static Single2 getInstance() {
		return single;
	}
}
