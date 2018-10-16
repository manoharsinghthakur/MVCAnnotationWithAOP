package com.annotationDemo.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@Pointcut("execution(com.annotationDemo.service.*.*(..))")
	public void getLogsForAllMethod(){
		
	}
	
	@Before("getLogsForAllMethod")
	public void beforeAdviceForTransferMethods(JoinPoint joinPoint) throws Throwable{
		System.out.println("***LoggingAspect.BeforeAdviceForTransferMethods()" +joinPoint.getSignature().getName());
	}
	
	@After("execution(com.annotationDemo.service.*.*(..))")
	public void afterAdviceforTranferMethods(JoinPoint joinPoint) throws Throwable {
		System.out.println("***LoggingAspect.afterAdviceForTransferMethods()" + joinPoint.getSignature().getName());

	}
	
	@Around("execution(com.annotationDemo.service.*.*(..))")
    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("logAround() is running!");
        System.out.println("hijacked method : " + joinPoint.getSignature().getName());
        System.out.println("hijacked arguents : " +Arrays.toString(joinPoint.getArgs()));
        
        System.out.println("Around before is rnning!");
        joinPoint.proceed(); //continue on the intercepted method
        System.out.println("Around after is running!");
        System.out.println("**************");
	}
	
}
