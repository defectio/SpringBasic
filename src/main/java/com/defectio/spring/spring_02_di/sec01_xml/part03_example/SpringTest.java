package com.defectio.spring.spring_02_di.sec01_xml.part03_example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	public static void main(String[] args) {

		String path = "sec01_xml/part03_example/di.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(path);

		Service svc = (Service) context.getBean("svc");
		svc.prn();
	
	} //end main

}  //end class
