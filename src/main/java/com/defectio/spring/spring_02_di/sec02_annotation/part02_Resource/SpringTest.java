package com.defectio.spring.spring_02_di.sec02_annotation.part02_Resource;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.defectio.spring.spring_02_di.XmlUtils;

public class SpringTest {

	public static void main(String[] args) {
		String pkgName = XmlUtils.getPackageName(SpringTest.class);
		String path = pkgName + "/animal.xml";
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(path);
		
		PetOwner person = context.getBean("petOwner", PetOwner.class);
		person.play();
		
		context.close();
	}

} //end class
