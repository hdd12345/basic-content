package single;

/**
 * 单例模式实现方式1：构造方法私有化，不允许外部通过构造方法来创建该类实例，只能通过该类的静态方法来获取实例
 * @author Administrator
 *
 */
public class Single1 {
	
	private static Single1 single = new Single1();
	
	private Single1() {
		
	}
	
	public static Single1 getInstance() {
		return single;
	}
}
