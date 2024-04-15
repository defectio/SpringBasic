package com.defectio.spring.spring_01_basic.simple03;

public class MessageBeanEnglish implements MessageBean{
	
	@Override
	public void sayHello(String name) {
		System.out.println("Hello, " +name+ "!!!");
	}
	
} //end class