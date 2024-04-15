package com.defectio.spring.spring_01_basic.simple01;

/**
 * 객체간의 의존성이 높으면(=결합도가 높으면) 개발하는 것보다 유지보수 비용이 더 많이 들 수도 있다.
 * 객체들간의 의존성을 약하게 해야 한다.
 * @param name
 */
public class MessageBean {
	
	public void sayHello(String name) {
		System.out.println("Hello, "+name+ "!!!" );
	}  //end sayHello()

} //end class
