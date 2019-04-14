package regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternDemo {

	public static void main(String[] args) {
		String regex = "\\d{3}";
		String str = "342deg4325";
		//将正则表达式封装成对象
		Pattern p = Pattern.compile(regex);
		//获得匹配器对象（将正则对象将需要操作的字符串想关联）
		Matcher m = p.matcher(str);
		//System.out.println(m.matches());
		System.out.println(m.find());//符合规则字串的查找
		System.out.println(m.group());//获取匹配后结果
		System.out.println(m.start());//上一次匹配的开始索引
		System.out.println(m.end());//最后匹配字符后的偏移量（即下一次匹配开始索引）
	}

}
