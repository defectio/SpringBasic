package com.defectio.spring.spring_02_di.sec01_xml.part09_Contact;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.defectio.spring.spring_02_di.sec01_xml.part09_Contact.service.ContactRegisterService;
import com.defectio.spring.spring_02_di.sec01_xml.part09_Contact.service.ContactSearchService;
import com.defectio.spring.spring_02_di.sec01_xml.part09_Contact.utils.InitSampleData;

public class MainClass {

	public static void main(String[] args) {

		/**
		 * IoC 컨테이너 생성
		 */
		String path = "sec01_xml/part09_Contact/appCtx.xml";
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext(path);

		/**
		 * 샘플 데이터
		 */
		InitSampleData initSampleData = ctx.getBean("initSampleData", InitSampleData.class);
		String[] names = initSampleData.getNames();
		String[] phoneNumbers = initSampleData.getPhoneNumbers();

		/**
		 * 데이터 등록
		 */
		ContactRegisterService registerService = ctx.getBean("registerService", ContactRegisterService.class);
		for (int i = 0; i < names.length; i++) {
			ContactSet contactSet = new ContactSet(names[i], phoneNumbers[i]);
			registerService.register(contactSet);
		}

		/**
		 * 데이터 조회
		 */
		ContactSearchService searchService = ctx.getBean("searchService", ContactSearchService.class);
		ContactSet contactSet = searchService.searchContact("류현진");
		System.out.println("name: " + contactSet.getName());
		System.out.println("phone number: " + contactSet.getPhoneNumber());
		System.out.println("------------------------------");

		contactSet = searchService.searchContact("손흥민");
		System.out.println("name: " + contactSet.getName());
		System.out.println("phone number: " + contactSet.getPhoneNumber());
		System.out.println("------------------------------");

		contactSet = searchService.searchContact("김연경");
		System.out.println("name: " + contactSet.getName());
		System.out.println("phone number: " + contactSet.getPhoneNumber());
		System.out.println("------------------------------");
	}

}
