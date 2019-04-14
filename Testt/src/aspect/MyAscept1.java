package aspect;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import util.MyServiceImpl;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;

@Aspect//������ע��
@Component
public class MyAscept1 {
	/**
	 * ǰ��֪ͨ����Ŀ�귽��֮ǰִ��
	 */
	@Before(value="MyAscept1.fun()")
	public void before() {
		System.out.println("ǰ��֪ͨ");
	}
	
	/**
	 * ����֪ͨ������Ŀ�귽���Ƿ�����쳣������֪ͨ����ִ��
	 */
	@After(value="execution(* util.MyServiceImpl.*(..))")
	public void after() {
		System.out.println("����֪ͨ");
	}
	
	/**
	 * ����֪ͨ����Ŀ�귽��ִ����֮��ִ�У�Ŀ�귽�������쳣ʱ��ִ�У�
	 */
	@AfterReturning(value="execution(* util.MyServiceImpl.*(..))")
	public void afterReturing() {
		System.out.println("����֪ͨ");
	}
	
	/**
	 * �쳣֪ͨ��Ŀ�귽�������쳣��ִ��
	 */
	@AfterThrowing(value="execution(* util.MyServiceImpl.*(..))")
	public void afterThrowing(JoinPoint joinPoint) {
		System.out.println("�쳣֪ͨ");
		PropertyConfigurator.configure( "classpath:log4j.properties " );
        Logger logger  =  Logger.getLogger(joinPoint.getTarget().getClass());
        logger.error("����������"+joinPoint.getSignature().getName());//��ӡ������
	}
	
	/**
	 * ����֪ͨ����Ŀ�귽������ָ��λ��ִ�У�ͨ��ProceedingJoinPoint�ֶ�ִ��Ŀ����󷽷�
	 * @param joinPoint
	 * @throws Throwable
	 */
//	@Around(value="execution(* util.MyServiceImpl.*(..))")
//	public void around(ProceedingJoinPoint joinPoint) throws Throwable {
//		System.out.println("����֪ͨ1");
//		//ִ��Ŀ����󷽷�
//		joinPoint.proceed();
//		System.out.println("����֪ͨ2");
//	}
	
	@Pointcut(value="execution(* util.MyServiceImpl.*(..))")
	public void fun() {	
		
	}
}
