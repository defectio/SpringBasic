package com.defectio.spring.spring_02_di.sec03_javaConfig.part01_bean_method_param;

import org.springframework.stereotype.Component;

@Component
public class Car {

	/**
	 * [JavaConfig를 사용하지만, @Autowired 어노테이션을 사용하지 않고 인젝션하는 방법]
	 * 	 
	 *  (1) @Bean 메서드를 인수로부터 취득 : @Bean에 주입할 객체를 매개변수로 선언한다(생성자 반드시 필요)
	 * 		- 생성자
	 * 		- setter
	 * 	 (2) @Bean 메서드를 불러들여서 취득
	 */
	
	private Engine v8;
	//Engine이라는 Type의 @Component가 있는 경우(Engine 클래스에 @Component 선언 했을 경우), 
	//@Autowired 선언이 없을 때 JavaConfig의 @Bean 메서드를 인수로부터 취득
	
	public Car() {
		System.out.println("Car 생성자");
	}
	
	// [1-1] @Bean 메서드를 인수로부터 취득 - 생성자로 취득
	public Car(Engine v8) {
		this.v8 = v8;
	}
	
	// [1-2] @Bean 메서드를 인수로부터 취득 - setter로 취득
	public void setV8(Engine v8) {
		this.v8 = v8;
	}
	
	public void run() {
		System.out.println("엔진을 이용하여 달립니다.");
		v8.exec();
	}

} //end class