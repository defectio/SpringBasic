package com.defectio.spring.spring_02_di.sec02_annotation.part01_Autowired;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	public static void main(String[] args) {
		String path = "sec02_annotation/part01_Autowired/animal.xml";
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(path);
		System.out.println("========컨테이너 생성========");
		
		// getBean() 메소드가 Object 타입으로 리턴함 -> PetOwner 타입으로 casting
		PetOwner person = (PetOwner) context.getBean("petOwner");
		person.play();
		
		/* 클래스 타입을 직접가져올 경우 -> casting 필요없음 */
//		PetOwner person2 = context.getBean("petOwner", PetOwner.class);
//		person2.play();
		
		context.close();
	}

}