package com.defectio.spring.spring_02_di.sec01_xml.part07_calculator.question;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	
	public static void main(String[] args) {
	
		/**
		 * 출력 결과
		 * result : 15
		 * result : 5
		 * result : 50
		 * 	result : 2
		 */
		String path ="sec01_xml/part06_calculator/question/applicationContext.xml";
		
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext(path);
		
		CalAssembler calAssembler = ctx.getBean("assemble", CalAssembler.class);
		calAssembler.assemble();

	}

}