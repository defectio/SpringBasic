package com.defectio.spring.spring_02_di.sec03_javaConfig.part00_basic;

import org.springframework.beans.factory.annotation.Autowired;

//@Component
public class Car {

	//@Autowired : 나 Engine 쓸 거니까 알아서 갖고와
	@Autowired
	private Engine v8;
	//Engine이라는 Type의 @Component가 있는 경우(Engine 클래스에 @Component 선언 했을 경우), 
	//DI Container가 자동으로 객체로 생성(Car, Engine)하고 @Autowired가 있는 객체(v8)에 주입하여 주기 때문에 별도의 setter가 필요하지 않음
	/*public void setV8(Engine v8) {
		this.v8 = v8;
	}*/
	
	public Car() {
		System.out.println("Car 생성자");
	}
	
	public void run() {
		System.out.println("엔진을 이용하여 달립니다.");
		v8.exec();
	}
	
} //end class