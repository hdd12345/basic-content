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

@Aspect//切面类注解
@Component
public class MyAscept1 {
	/**
	 * 前置通知，在目标方法之前执行
	 */
	@Before(value="MyAscept1.fun()")
	public void before() {
		System.out.println("前置通知");
	}
	
	/**
	 * 最终通知，无论目标方法是否放生异常，最终通知都会执行
	 */
	@After(value="execution(* util.MyServiceImpl.*(..))")
	public void after() {
		System.out.println("最终通知");
	}
	
	/**
	 * 后置通知，在目标方法执行完之后执行（目标方法发生异常时不执行）
	 */
	@AfterReturning(value="execution(* util.MyServiceImpl.*(..))")
	public void afterReturing() {
		System.out.println("后置通知");
	}
	
	/**
	 * 异常通知，目标方法发生异常后执行
	 */
	@AfterThrowing(value="execution(* util.MyServiceImpl.*(..))")
	public void afterThrowing(JoinPoint joinPoint) {
		System.out.println("异常通知");
		PropertyConfigurator.configure( "classpath:log4j.properties " );
        Logger logger  =  Logger.getLogger(joinPoint.getTarget().getClass());
        logger.error("出错方法名："+joinPoint.getSignature().getName());//打印方法名
	}
	
	/**
	 * 环绕通知，将目标方法放在指定位置执行，通过ProceedingJoinPoint手动执行目标对象方法
	 * @param joinPoint
	 * @throws Throwable
	 */
//	@Around(value="execution(* util.MyServiceImpl.*(..))")
//	public void around(ProceedingJoinPoint joinPoint) throws Throwable {
//		System.out.println("环绕通知1");
//		//执行目标对象方法
//		joinPoint.proceed();
//		System.out.println("环绕通知2");
//	}
	
	@Pointcut(value="execution(* util.MyServiceImpl.*(..))")
	public void fun() {	
		
	}
}
