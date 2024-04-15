package com.defectio.spring.spring_02_di.sec01_xml.part07_calculator.answer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
//		new CalAssembler();

		String path = "sec01_xml/part06_calculator/answer/applicationContext.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(path);

		CalAssembler assembler = ctx.getBean("calAssembler", CalAssembler.class);
		assembler.assemble();

	}
	
}