package com.douzone.aoptest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("config/applicationContext.xml");
		//설정파일 이름을 적어준다.
		
		ProductService ps = ac.getBean(ProductService.class);
		ProductVo vo = ps.find("TV");
		System.out.println(vo);
	}

}
