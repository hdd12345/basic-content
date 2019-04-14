package single;

/**
 * 单例模式实现方式2：静态内部类
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
