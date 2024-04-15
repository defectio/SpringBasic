package com.defectio.spring.spring_02_di.sec03_javaConfig.part04_Product;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//이 Java 클래스가 JavaConfig임을 나타내는 어노테이션(스프링 설정 클래스)
@Configuration
//컴포넌트의 검색 장소를 지정하기 위해서 context:component-scan 태그를 대신한다.
//@ComponentScan
public class AppConfig {

	/*
	 * JavaConfig를 사용해서 @Autowired 어노테이션을 사용하지 않고 인젝션하기 위해서는 프로그램에서 구현할 필요가 있다.
	 * 	 [방법 1] @Bean 메서드를 인수로부터 취득
	 * 	 [방법 2] @Bean 메서드를 불러들여서 취득
	 * 	 [방법 3] @Autowired 프로퍼티에서 취득
	 */
	@Bean
	public ProductDaoImp productDao() {
		return new ProductDaoImp();
	}
	
	/**
	 *  [방법 1] @Bean 메서드를 인수로부터 취득
	 *   	- @Bean이 선언된 메소드의 인수를 이용해서 객체를 생성한다.
	 *  	- 위에서 @Bean으로 생성한 ProductDaoImp 타입 객체가 자동으로 주입됨
	 */
	@Bean		
	public ProductServiceImp productService(ProductDao productDao) {
		/**
		 * 주입된 productDao를 ProductServiceImp에서 사용함(의존관계 설정)
		 */
		return new ProductServiceImp(productDao);
	}

	
	/**
	 *  [방법 2] @Bean 메서드를 불러들여서 취득
	 *  Config.java에 설정된 @Bean 메서드를 실행하고, 그 결과를 이용해서 인젝션 실행
	 */
//	@Bean
//	public ProductServiceImp productService() {
//		return new ProductServiceImp(productDao());
//	}
	
} //end class
