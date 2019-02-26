package com.douzone.aoptest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//프록시
@Aspect
@Component
public class MyAspect {

	@Before("execution(ProductVo com.douzone.aoptest.ProductService.find(..))") // 메소드 지정
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

	// 예외 발생할떄 뜬다.
	@AfterThrowing("execution(* *..*.ProductService.*(..))")
	public void afterThrowing() {
		System.out.println("call [afterThrowing advice]");
	}

	// 비포 에프터 위에꺼쓰는거 보다 그냥 어라운드쓰는게 좋다.
	@Around("execution(* *..*.ProductService.*(..))")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		// before
		System.out.println("call [around advice] : before");

		// Point Cut이 되는 메소드 호출
		//Object[] parameters = {"camera"};
		//Object result = pjp.proceed(parameters);
		Object result = pjp.proceed();

		// after
		System.out.println("call [around advice] : after");

		//반환
		return result;
	}

}
