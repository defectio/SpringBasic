package com.defectio.spring.spring_02_di.sec03_javaConfig.part00_basic;

//DI 컨테이너가 자동으로 Engine을 bean 객체로 생성함.
//@Component
public class Engine {

	public Engine() {
		System.out.println("Engine 생성자");
	}
	
	public void exec() {
		System.out.println("엔진이 동작합니다.");
	}

}