package com.defectio.spring.spring_02_di.sec03_javaConfig.part03_bean_autowired_property;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringTest {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		Car car = ctx.getBean(Car.class);
		Car car2 = (Car) ctx.getBean("myCar");

		car.run();
		car2.run();
	}
	
}
