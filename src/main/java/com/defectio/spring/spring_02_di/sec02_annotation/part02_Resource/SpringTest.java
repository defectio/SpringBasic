package com.defectio.spring.spring_02_di.sec02_annotation.part02_Resource;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	public static void main(String[] args) {
		String path = "sec02_annotation/part02_Resource/animal.xml";
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(path);
		
		PetOwner person = (PetOwner) context.getBean("petOwner");
		person.play();
		
		context.close();
	}

} //end class
