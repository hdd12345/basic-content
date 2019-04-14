package com.cakeshop.aspect;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect//切面类注解
@Component
public class MyAspect {
	/**
	 * 异常通知，目标方法发生异常后执行
	 */
	@AfterThrowing(pointcut="execution(* com.cakeshop.serviceImpl.*.*(..))")
	public void afterThrowing(JoinPoint joinPoint) {
		PropertyConfigurator.configure( "classpath:log4j.properties" );
        Logger logger  =  Logger.getLogger(joinPoint.getTarget().getClass());
        logger.error("出错方法名："+joinPoint.getSignature().getName());//打印方法名
	}
}
