package com.defectio.spring.spring_03_aop.sec02_annotation.part01_basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("sec02_annotation/part01_basic/aop.xml");
		System.out.println("======컨테이너 생성======");
		
		Service svc =(Service) context.getBean("svc");
		
		//aop:before
		System.out.println("[aop:before]");
		svc.prn1();
		System.out.println();
		svc.prn1(10);
		System.out.println();
		svc.prn1(10,20);
		System.out.println("--------------------------");
		
		//aop:after
		System.out.println("[aop:after]");
		svc.prn2();
		System.out.println("--------------------------");
		
		//aop:after-returning
		System.out.println("[aop:after-returning]");
		svc.prn3();
		System.out.println("--------------------------");
		
		//예외 처리 하지 않음.
		/*System.out.println("[aop:after-throwing]");
		svc.prn4();
		System.out.println("--------------------------");*/
		
		//aop:after-throwing
		//예외 처리하였음. after-throwing -> 실행메소드에서 예외처리
		System.out.println("[aop:after-throwing]");
		try {
			svc.prn4();
		} catch(Exception ex) {}
		System.out.println("--------------------------");
	
		//aop:around -> proceed() 메소드 호출한데서 예외처리
		System.out.println("[aop:around]");
		svc.prn5();
		
	}  //end main

}  //end class
