package com.defectio.spring.spring_02_di.sec01_xml.part07_calculator.answer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.defectio.spring.spring_02_di.XmlUtils;

public class MainClass {
	public static void main(String[] args) {
//		new CalAssembler();
		
		String pkgName = XmlUtils.getPackageName(MainClass.class);
		String path = pkgName + "/applicationContext.xml";

		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext(path);

		CalAssembler assembler = ctx.getBean("calAssembler", CalAssembler.class);
		assembler.assemble();

	}
	
}