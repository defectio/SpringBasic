package com.defectio.spring.spring_02_di.sec03_javaConfig.part01_bean_method_param;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
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
	 * [@Bean 메서드를 인수로부터 취득 - 생성자로 취득]
	 * 		- @Autowired 어노테이션을 설정하지 않고서 메서드의 인수에 설정됨.
	 * 		- 위에서 @Bean으로 생성한 Engine 객체가 주입됨(싱글톤 - 동일한 객체)
	 *  	- JavaConfig가 분할된 경우에도 문제없이 취득할 수 있다.
	 *  	- Car 클래스에 Engine 타입을 매개변수로 받는 생성자가 있어야함
	 *  
	 *  <bean id="myCar" class="패키지명.Car">
	 * 		<constructor-arg ref="engine"/>
	 *  </bean>
	 * @param e
	 * @return
	 */
	@Bean(name="myCar")	 
	public Car car(Engine e) {
		// [1-2] @Bean 메서드를 인수로부터 취득 - 생성자로 취득
		return new Car(e);
		
		// [1-2] @Bean 메서드를 인수로부터 취득 - setter로 취득(Car 클래스에 Engine 타입을 매개변수로 받는 생성자가 있어야함)
//		Car c = new Car();
//		c.setV8(e);
//		return c;
	}
	
} //end class