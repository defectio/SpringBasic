package com.defectio.spring.spring_01_basic.simple02;

public class MessageBeanEnglish implements MessageBean{
	
	//MessageBean(인터페이스)의 구현객체 이므로, 인터페이스에 정의된 추상메소드를 재정의해야한다
	@Override
	public void sayHello(String name) {
		System.out.println("Hello, " +name+ "!!!");
	}
	
} //end class