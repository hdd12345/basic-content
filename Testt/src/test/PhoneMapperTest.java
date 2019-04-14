package test;

import static org.junit.Assert.*;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.PhoneMapper;
import entity.Phone;

public class PhoneMapperTest {
	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void setUp() throws Exception {
		//读取mybatis-config.xml文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //初始化mybatis,创建SqlSessionFactory类的实例
        sqlSessionFactory =  new SqlSessionFactoryBuilder().build(resourceAsStream);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSelectPhone() {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		PhoneMapper phoneMapper = sqlSession.getMapper(PhoneMapper.class);
		Phone phone = phoneMapper.selectPhone(1);
		System.out.println(phone);
	}

}
