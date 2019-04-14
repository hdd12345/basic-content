package single;

public class SingleDemo {
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Single1 s1 = Single1.getInstance();
		Single1 s2 = Single1.getInstance();
		System.out.println(s1);
		System.out.println(s2);
		
		SingleBuilder sb = new SingleBuilder();
		Single s3 = sb.getInstance();
		Single s4 = sb.getInstance();
		System.out.println(s3);
		System.out.println(s4);
	}

}
