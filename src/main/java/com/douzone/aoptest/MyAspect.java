package com.douzone.aoptest;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//프록시
@Aspect
@Component
public class MyAspect {
	
	@Before("execution(ProductVo com.douzone.aoptest.ProductService.find(..))")//메소드 지정 
	public void beforeAdvice() {
		System.out.println("call before advice");
	}
	
	@After("execution(* *..*.ProductService.*(..))")
	public void afterAdvice() {
		System.out.println("call [after advice]");
	}
	
	@AfterReturning("execution(* *..*.ProductService.*(..))")
	public void afterReturningAdvice() {
		System.out.println("call [afterReturning advice]");
	}
}
