package test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import util.MyServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:aoptest.xml")
public class MyAspectTest {
//	@Autowired
//	@Qualifier(value="myServiceImpl")
	@Resource(name="myServiceImpl")
	private MyServiceImpl msi;
	
	@Test
	public void run1() {
		msi.myMethod();
	}
}
