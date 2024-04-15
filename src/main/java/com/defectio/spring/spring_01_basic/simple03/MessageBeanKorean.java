package com.defectio.spring.spring_01_basic.simple03;

public class MessageBeanKorean implements MessageBean{
	
	@Override
	public void sayHello(String name) {
		System.out.println("안녕하세요, " +name+ "!!!");
	}

} //end class