package com.defectio.spring.spring_03_aop.sec02_annotation.part02_timecheck;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	public static void main(String[] args) {
		String path = "sec02_annotation/part02_timecheck/aop.xml";
		
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext(path);
		Service svc = (Service) ctx.getBean("svc");
				
		/**
		 *  [prn() 호출 시 메소드 실행 순서]
		 *    (1) process() 메소드 실행 
		 *    (2) process() 메소드 실행 중 proceed() 메소드 호출 : prn() 메소드 실행
		 *    (3) prn() 메소드 종료 후  process() 메소드 잔여 로직 실행
		 */
		svc.prn();
	}

}
