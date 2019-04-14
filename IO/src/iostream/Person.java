package iostream;

import java.io.Serializable;

public class Person implements Serializable {
		//反序列化时若输入流中的serialVersionUID与该类中的不一致，则不会反序列化成功，InvalidCastException
		private static final long serialVersionUID = 1L;
		private String name;
		private transient int age;
		private String sex;
		
		public Person(String name,int age,String sex){
			this.name=name;
			this.age=age;
			this.sex=sex;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "name:"+this.name+",age:"+this.age+",sex:"+this.sex;
		}
		
}
