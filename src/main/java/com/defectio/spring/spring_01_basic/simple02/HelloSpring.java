package com.defectio.spring.spring_01_basic.simple02;

/**
 * interface를 이용해서 결합도를 낮춤(의존관계를 약하게 설정)
 * @author defec
 */
public class HelloSpring {

	public static void main(String[] args) {
		// interfrace를 구현한 구현 객체를 직접 생성
		MessageBean bean = new MessageBeanEnglish();
		bean.sayHello("spring");

		// interfrace를 구현한 구현 객체를 직접 생성
		bean = new MessageBeanKorean();
		bean.sayHello("스프링");
	} //end main

} //end class