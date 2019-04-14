import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;

import threadlocaltest.User;

import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class TestDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Integer a = new Integer(1);
//		Integer b = new Integer(2);
//		User a = new User("abc",12);
//		User b = new User("abc",12);
		
//		String a = new String("abc");
//		String b = new String("abc");
//		System.out.println(a==b);
//		System.out.println(a.equals(b));
//		System.out.println(a.hashCode());
//		System.out.println(b.hashCode());
		
//		HashSet<User> hs = new HashSet<>();
//		hs.add(new User("abc1",11));
//		hs.add(new User("abc2",12));
//		hs.add(new User("abc3",13));
//		System.out.println(hs.add(new User("abc2",12)));
//		Iterator<User> it = hs.iterator();
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
		
//		TreeSet<User> ts = new TreeSet<>();
//		ts.add(new User("abc1",11));
//		ts.add(new User("abc1",12));
//		ts.add(new User("abc3",13));
//		ts.add(new User("abc2",11));
//		Iterator<User> it = ts.iterator();
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
		
//		TreeSet<User> ts = new TreeSet<>(new MyComparator());
//		ts.add(new User("abc1",11));
//		ts.add(new User("abc1",12));
//		ts.add(new User("abc3",13));
//		ts.add(new User("abc2",11));
//		Iterator<User> it = ts.iterator();
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
		
//		TreeMap<String,User> tm = new TreeMap<>();
//		tm.put("1",new User("abc1",11));
//		tm.put("2",new User("abc1",12));
//		tm.put("3",new User("abc3",13));
//		tm.put("4",new User("abc2",11));
//		Set<String> set = tm.keySet();
//		Iterator<String> it = set.iterator();
//		while(it.hasNext()) {
//			String str = it.next();
//			User user = tm.get(str);
//			System.out.println(str+",,,"+user);
//		}
		
		TreeMap<User,String> tm = new TreeMap<>(new MyComparator());
		tm.put(new User("abc1",11),"1");
		tm.put(new User("abc1",12),"2");
		tm.put(new User("abc3",13),"3");
		tm.put(new User("abc2",11),"4");
		Set<Entry<User,String>> set = tm.entrySet();
		Iterator<Entry<User,String>> ite = set.iterator();
		while(ite.hasNext()) {
			Entry<User,String> e = ite.next();
			System.out.println(e.getValue()+",,,"+e.getKey());
		}
	}

}
