package com.defectio.spring.spring_03_aop.sec01_xml.part01_basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *  AOP 기능 사용하려면 <dependency>에 aspectj 추가
 *  pom.xml에 aspectj 추가하지 않아서 발생한 오류 -> maven repository가서 library 복붙 해와야 함.
 *  Error creating bean with name 'org.springframework.aop.aspectj.AspectJPointcutAdvisor#0':
 *  Cannot create inner bean '(inner bean)#14028087' of type [org.springframework.aop.aspectj.AspectJMethodBeforeAdvice] while setting constructor argument;
 * @author defec
 */
public class SpringTest {

	public static void main(String[] args) {
		String path = "sec01_xml/part01_basic/aop.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(path);
		System.out.println("======컨테이너 생성 완료======");
		Service svc =(Service) context.getBean("svc");
		
		//aop:before
		System.out.println("[aop:before]");
		svc.prn1();
		System.out.println();
		
		svc.prn1(10);
		System.out.println();
		
		svc.prn1(10,20);
		System.out.println("--------------------------");
		
		//aop:after
		System.out.println("[aop:after]");
		svc.prn2();
		System.out.println("--------------------------");
		
		//aop:after-returning
		System.out.println("[aop:after-returning]");
		svc.prn3();
		System.out.println("--------------------------");
		
		//예외 처리 하지 않음.
		/*System.out.println("[aop:after-throwing]");
		svc.prn4();
		System.out.println("--------------------------"); */
		
		//aop:after-throwing
		//예외 처리하였음. after-throwing -> 실행메소드에서 예외처리
		System.out.println("[aop:after-throwing]");
		try {
			svc.prn4();
		} catch (Exception ex) {
			System.out.println("prn4() 메소드 실행 시 예외가 발생하면 comm4 메소드가 호출되고, 그 이후에 catch문 실행됨");
		}
		System.out.println("--------------------------");
	
		//aop:around -> proceed() 메소드 호출한데서 예외처리
		System.out.println("[aop:around]");
		svc.prn5();
		
	}  //end main

}  //end class
