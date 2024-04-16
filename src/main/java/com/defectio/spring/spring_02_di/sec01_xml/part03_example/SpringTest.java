package com.defectio.spring.spring_02_di.sec01_xml.part03_example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.defectio.spring.spring_02_di.XmlUtils;

public class SpringTest {

	public static void main(String[] args) {

		String pkgName = XmlUtils.getPackageName(SpringTest.class);
		String path = pkgName + "/di.xml";
		
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(path);

		Service svc = (Service) context.getBean("svc");
		svc.prn();
	
	} //end main

}  //end class
