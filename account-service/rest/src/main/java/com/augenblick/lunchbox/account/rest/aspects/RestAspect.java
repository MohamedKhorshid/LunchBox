package com.augenblick.lunchbox.account.rest.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class RestAspect {

	Logger logger = LoggerFactory.getLogger(RestAspect.class);
	
	@Pointcut("execution(* com.augenblick.lunchbox.account.rest.controller.*.*(..))")
	protected void allControllers() {}
	
	@Before("allControllers()")
	public void beforeAdvice(JoinPoint joinPoint) {
		logger.info("[" + joinPoint.getTarget() + "] being called");
	}
	
	@AfterReturning(pointcut = "allControllers()", returning = "retVal")
	public void afterReturningAdvice(JoinPoint joinPoint, Object retVal) {
		logger.info("[" + joinPoint.getTarget() + "] returned: " + retVal);
	}
	
	@AfterThrowing(pointcut = "allControllers()", throwing = "ex")
	public void afterThrowingAdvice(JoinPoint joinPoint, Exception ex) {
		logger.info("[" + joinPoint.getTarget() + "] threw exception: " + ex.getMessage());
	}
}
