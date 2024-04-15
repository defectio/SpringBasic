package com.defectio.spring.spring_02_di.sec03_javaConfig.part00_basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		/**
		 * AnnotationConfigApplicationContext는 JavaConfing 클래스의
		 * @Bean이 붙어있는 메소드를 자동으로 실행하고, 각 메소드에서 return되는 객체들을 싱글톤으로 관리함
		 *		-> 한번 만들어 지면 같은 객체이다. 
		 */
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		ApplicationContext ctx2 = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		//getBean(클래스명.class) 클래스타입으로 가져올 때의 장점 
		//(1) 메소드명 오타를 신경 쓸 필요가 없다.
		//(2) 형변환을 할 필요가 없다.
		Car car = ctx.getBean(Car.class);
		
		//getBean(메소드명)으로 가져올 경우 JavaConfig 클래스에 선언한 메소드명으로 가져온다.
		//getBean(메소드명)의 리턴타입이 object 타입 -> 클래스 타입으로 형변환 해야 한다.
		//Car car2 = (Car) ctx.getBean("car");
		
		//JavaConfig의 @Bean의 name 속성이 명시된 경우, @Bean(name="id명")
		Car car2 = (Car) ctx.getBean("myCar");
		
		car.run();
		//ctx.getBean(Car.class).run();
		car2.run();
		
		/**
		 * AnnotationConfigApplicationContext에 의해서 생성 -> 싱글톤으로 관리됨
		 * car와 car2는 같은 객체를 참조한다. 
		 */
		System.out.println(car);
		System.out.println(car2);

		///////////////////////////////////////////////////////////////////////////
		Car car_a = ctx2.getBean(Car.class);
		Car car_b = (Car) ctx2.getBean("myCar");
		
		System.out.println(car_a);
		System.out.println(car_b);
	
	}
}
