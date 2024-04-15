package com.defectio.spring.spring_02_di.sec03_javaConfig.part00_basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration : 이 클래스가 JavaConfig용 클래스라는 것을 명시함. 즉, 빈 설정 xml 파일을 대체 설정 클래스.
 * 개발자가 직접 작성한 class를 빈으로 만든다.
 * @author defec
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
	 * Bean 객체 생성 방법 : Engine 객체를 반환하는 메소드를 만들고 @Bean 어노테이션 부여
	 * <bean id="engine" class="패키지명.Engine"/>
	 *  -> 개발자가 작성한 메소드를 통해서 반환된 객체를 bean 객체로 만든다.
	 * @return
	 */
	@Bean  
	public Engine engine() {
		return new Engine();
	}
	
	/**
	 * @Bean의 name 속성으로 id값을 줄 수 있다.
	 */
	// @Bean(name="빈객체의 id명")
	@Bean(name="myCar")	
	public Car car() {
		return new Car();
	}
	
}
