package com.defectio.spring.spring_02_di.sec02_annotation.part01_Autowired;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.defectio.spring.spring_02_di.XmlUtils;

public class SpringTest {

	public static void main(String[] args) {
		String pkgName = XmlUtils.getPackageName(SpringTest.class);
		String path = pkgName + "/animal.xml";
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(path);
		System.out.println("========컨테이너 생성========");
		
		/**
		 * getBean() 메소드가 Object 타입으로 리턴함
		 *   -> PetOwner 타입으로 casting 해야한다.
		 */
		PetOwner person = (PetOwner) context.getBean("petOwner");
		person.play();
		
		/**
		 * getBean() 메소드에 클래스도 명시할 경우
		 *   -> 지정된 class 타입으로 리턴되기 때문에 casting할 필요 없음
		 */
		PetOwner person2 = context.getBean("petOwner", PetOwner.class);
		person2.play();
		
		context.close();
	}

}