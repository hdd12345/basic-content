package single;

/**
 * ����ģʽʵ�ַ�ʽ1�����췽��˽�л����������ⲿͨ�����췽������������ʵ����ֻ��ͨ������ľ�̬��������ȡʵ��
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
