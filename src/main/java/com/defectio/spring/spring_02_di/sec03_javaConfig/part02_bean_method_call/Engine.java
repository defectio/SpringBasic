package com.defectio.spring.spring_02_di.sec03_javaConfig.part02_bean_method_call;

public class Engine {

	public Engine() {
		System.out.println("Engine 생성자");
	}
	
	public void exec() {
		System.out.println("엔진이 동작합니다.");
	}
	
} //end class