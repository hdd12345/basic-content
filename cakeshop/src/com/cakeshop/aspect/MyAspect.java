package com.cakeshop.aspect;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect//������ע��
@Component
public class MyAspect {
	/**
	 * �쳣֪ͨ��Ŀ�귽�������쳣��ִ��
	 */
	@AfterThrowing(pointcut="execution(* com.cakeshop.serviceImpl.*.*(..))")
	public void afterThrowing(JoinPoint joinPoint) {
		PropertyConfigurator.configure( "classpath:log4j.properties" );
        Logger logger  =  Logger.getLogger(joinPoint.getTarget().getClass());
        logger.error("����������"+joinPoint.getSignature().getName());//��ӡ������
	}
}
