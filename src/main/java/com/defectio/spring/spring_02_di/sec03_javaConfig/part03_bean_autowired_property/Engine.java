package com.defectio.spring.spring_02_di.sec03_javaConfig.part03_bean_autowired_property;

import org.springframework.stereotype.Component;

@Component
public class Engine {

	public Engine() {
		System.out.println("Engine 생성자");
	}

	public void exec() {
		System.out.println("엔진이 동작합니다.");
	}
}
