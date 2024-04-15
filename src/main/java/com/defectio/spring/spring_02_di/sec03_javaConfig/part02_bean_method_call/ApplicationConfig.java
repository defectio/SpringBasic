package com.defectio.spring.spring_02_di.sec03_javaConfig.part02_bean_method_call;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration : 이 클래스가 JavaConfig용 클래스라는 것을 명시함. 즉, 빈 설정 xml 파일을 대체 설정 클래스.
 */
@Configuration

/**
 * @Component 어노테이션 및 stereotype(@Controller, @Service, @Repository)이 부여된 Class 들을 자동으로 Scan 하여 Bean으로 등록해준다.
 * package명으로 Scan의 범위를 지정할 수 있다.
 * 
 * [1] @ComponentScan("spring_02_di.sec03_javaConfig.part00_basic")  //가능
 * [2] @ComponentScan("sec03_javaConfig.part00_basic")  //가능
 * [3] @ComponentScan("part00_basic")  //가능
 * [4] 선언 안하는 것도 가능
 * [5] @ComponentScan  //가능
 */
public class ApplicationConfig {
	//@Bean 어노테이션에 name 속성이 없으면 메소드명으로 호출해야함.
	//@Bean 어노테이션에 name 속성이 있으면 그 값으로 호출해야함.

	/** 
	 * Engine객체를 Bean 객체로 생성해서 리턴함.
	 */
	@Bean
	public Engine engine() {
		return new Engine();
	}
	
	/**
	 * [@Bean 메서드를 호출하여 취득]
	 * 		- Car에 생성자 추가해야함.
	 *  	- 같은 JavaConfig 안에 @Bean 메서드가 정의 되어 있어야 한다.
	 *  	- 특징 : 인젝션 대상의 오브젝트가 어디서 생성되고 있는지 찾기 쉽다.
	 * @param e
	 * @return
	 */
	@Bean(name="myCar")	 
	public Car car() {   
		return new Car(engine());
	}
	
} //end class