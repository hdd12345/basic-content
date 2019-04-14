package iostream;

import java.io.Serializable;

public class Person implements Serializable {
		//�����л�ʱ���������е�serialVersionUID������еĲ�һ�£��򲻻ᷴ���л��ɹ���InvalidCastException
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
