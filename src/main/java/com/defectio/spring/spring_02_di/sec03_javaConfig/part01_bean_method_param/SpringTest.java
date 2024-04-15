package com.defectio.spring.spring_02_di.sec03_javaConfig.part01_bean_method_param;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringTest {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		System.out.println("=======컨테이너 생성 완료=======");
		
		Car car = ctx.getBean(Car.class);
		Car car2 = (Car) ctx.getBean("myCar");

		System.out.println(car);
		System.out.println(car2);
		car.run();
		car2.run();

	} // end main

} // end class