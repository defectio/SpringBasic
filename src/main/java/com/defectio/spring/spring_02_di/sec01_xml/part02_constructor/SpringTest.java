package com.defectio.spring.spring_02_di.sec01_xml.part02_constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.defectio.spring.spring_02_di.XmlUtils;

public class SpringTest {

	public static void main(String[] args) {
		// ClassPath
		String pkgName = XmlUtils.getPackageName(SpringTest.class);
		String path = pkgName + "/di.xml";
		
		/**
		 * [ApplicationContext 컨테이너] 생성 
		 * -> path에 잡혀있던 di.xml에 설정해놓은 빈들이 컨테이너(context)에 생성됨.
		 * 
		 * 컨테이너 생성되고 나서 part02_constructor/di.xml에 설정되어 있던 bean 객체들이 전부 생성됨.
		 */
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(path);
		System.out.println("==========[컨테이너 생성 완료]==========");
		
		/**
		 *  컨테이너에 생성된 빈들을 인터페이스로 받는다. -> 다형성
		 */
		// [1] 기본생성자로 생성된 빈을 가져옴.
		Service svc = (Service) context.getBean("svc");
		svc.prn1();
		
		// [2] 생성자 매개변수(name)로 생성된 빈을 가져옴.
		Service svc1 = (Service) context.getBean("svc1");
		svc1.prn1();
		
		// [3] 생성자 매개변수 2개(int age, String dept)로 생성된 빈을 가져옴 */
		Service svc2 = (Service) context.getBean("svc2");
		svc2.prn2();

		// [4] 객체타입(참조 타입)으로 생성된 빈을 가져옴.
		//Random ran = new Random();
		//Service svc3 = new ServiceImp(ran);
		Service svc3 = (Service) context.getBean("svc3");
		svc3.prn3();		
	}

}
