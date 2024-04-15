package com.defectio.spring.spring_02_di.sec01_xml.part04_property;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	public static void main(String[] args) {
		String path = "sec01_xml/part04_property/di.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(path);
		
		Service svc = (Service) context.getBean("svc1");
		svc.prn1();

		svc = (Service) context.getBean("svc2");
		svc.prn2();
		
		svc = (Service) context.getBean("svc3");
		svc.prn3();
		
		svc = (Service) context.getBean("svc4");
		svc.prn1();
		
		svc=(Service) context.getBean("svc5");
		svc.prn2();
	} //end main

}  //end Class
