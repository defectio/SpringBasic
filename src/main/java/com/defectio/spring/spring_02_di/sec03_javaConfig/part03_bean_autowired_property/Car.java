package com.defectio.spring.spring_02_di.sec03_javaConfig.part03_bean_autowired_property;

import org.springframework.stereotype.Component;

@Component
public class Car {

	private Engine v8;
	//Engine이라는 Type의 @Component가 있는 경우(Engine 클래스에 @Component 선언 했을 경우), 
	//@Autowired 선언이 없을 때 JavaConfig의 @Bean 메서드를 불러들여서 취득
	
	public Car() {
		System.out.println("Car 생성자");
	}
	
	/**
	 *  @Autowired 프로퍼티에서 취득 - 생성자가 있어야함.
	 * @param v8
	 */
	public Car(Engine v8) {
		this.v8 = v8;
	}
	
	public void run() {
		System.out.println("엔진을 이용하여 달립니다.");
		v8.exec();
	}
}
