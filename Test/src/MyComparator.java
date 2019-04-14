import java.util.Comparator;

import threadlocaltest.User;

public class MyComparator implements Comparator<User> {

	@Override
	public int compare(User user1, User user2) {
		if(user1.getUsername().compareTo(user2.getUsername())!=0)
			return user1.getUsername().compareTo(user2.getUsername());
		return user1.getAge()-user2.getAge();
	}

}
