package com.defectio.spring.spring_02_di.sec01_xml.part04_property;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.defectio.spring.spring_02_di.XmlUtils;

public class SpringTest {

	public static void main(String[] args) {
		String pkgName = XmlUtils.getPackageName(SpringTest.class);
		String path = pkgName + "/di.xml";
		
		@SuppressWarnings("resource")
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
