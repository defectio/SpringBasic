package com.defectio.spring.spring_02_di.sec01_xml.part05_example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.defectio.spring.spring_02_di.XmlUtils;

public class SpringTest {

	public static void main(String[] ar) {
		String pkgName = XmlUtils.getPackageName(SpringTest.class);
		String path = pkgName + "/di.xml";
		
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(path);
		
		Service svc = (Service) context.getBean("svc");
		System.out.println("[명시적 인젝션]");
		svc.prn1();
		svc.prn2();
		System.out.println();
		

		svc = (Service) context.getBean("service");
		System.out.println("[autowired 인젝션]");
		svc.prn1();
		svc.prn2();
		System.out.println();
		
		svc = (Service) context.getBean("p");
		System.out.println("[namespace 이용 인젝션]");
		svc.prn1();
		svc.prn2();

	}  //end main()

}  //end class
