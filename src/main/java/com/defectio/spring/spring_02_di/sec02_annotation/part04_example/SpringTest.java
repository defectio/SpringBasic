package com.defectio.spring.spring_02_di.sec02_annotation.part04_example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	public static void main(String[] args) {

		String path = "sec02_annotation/part04_example1/di.xml";
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(path);

		Service svc = (Service) context.getBean("svc");
		svc.prn();
		
		context.close();
	} //end main

}  //end class
