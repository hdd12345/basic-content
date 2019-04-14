package regular;

public class RegularDemo {

	public static void main(String[] args) {
		//括号将规则分组，每一个组都有编号，从1开始，想要使用已有的组可以通过\n来获取，\1表示使用第一组
		//叠词切割
		//splitDemo("dsdfffweecd","(.)\\1+");
		//反斜杠切割
		//splitDemo("C:\\ads\\hello.txt","\\\\");
		//将叠词替换成单个
		System.out.println("hhhhdeaffefddkeei".replaceAll("(.)\\1+","$1"));//$1获取前面的第一组
	}
	
	public static void splitDemo(String str,String regex) {
		String arr[] = str.split(regex);
		for(String s:arr) {
			System.out.println(s);
		}
	}
}
