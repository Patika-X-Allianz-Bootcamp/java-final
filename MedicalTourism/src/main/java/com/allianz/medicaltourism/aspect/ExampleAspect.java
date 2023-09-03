package com.allianz.medicaltourism.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExampleAspect {

	@Before(value = "execution(* com.allianz.medicaltourism.service.*.*(..))")
	public void beforeExample(JoinPoint joinPoint) {
		System.out.println("Before" + joinPoint.getSignature().getName() + "method");
	}

	@After(value = "execution(* com.allianz.medicaltourism.service.*.*(..))")
	public void afterExample(JoinPoint joinPoint) {
		System.out.println("Before" + joinPoint.getSignature().getName() + "method");
	}

	@Around(value = "execution(* com.allianz.medicaltourism.service.*.*(..))")
	public Object aroundExample(ProceedingJoinPoint joinPoint) throws Throwable {
		Object proceed = joinPoint.proceed();
		System.out.println("Before" + joinPoint.getSignature().getName() + "method");
		return proceed;
	}
}
