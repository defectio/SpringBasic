package com.defectio.spring.spring_05_tx.sec03_Advice_Annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.defectio.spring.spring_02_di.XmlUtils;

public class SpringTest {

	public static void main(String[] args) {
		String pkgName = XmlUtils.getPackageName(SpringTest.class);
		String path = pkgName + "/tx.xml";
		
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(path);
		
		Service svc = context.getBean("svc", Service.class);
		try {
			svc.insertProcess();
			System.out.println("트랜잭션 정상");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
}