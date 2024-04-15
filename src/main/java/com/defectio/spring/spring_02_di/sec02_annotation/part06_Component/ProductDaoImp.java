package com.defectio.spring.spring_02_di.sec02_annotation.part06_Component;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

/*
 * [@Component] : DI 컨테이너가 관리한, 주로 인젝션을 위한 인스턴스를 설정하는 것.
 * 	 - 클래스 선언 앞에 @Component 를 붙이면 스프링이 DI 컨테이너가 찾아서 관리하고, 
 *    @Autowired가 붙은 인스턴스 변수나 메서드에 인젝션 해준다.
 *  - 즉, @Component가 붙은 클래스는 bean 객체로 생성/관리가 될 클래스이다.
 * 	 - 또한, byName으로 인젝션 받고 싶으면 @Component 뒤에 이름을 지정 할 수도 있다. 
 *     ex) @Component("name명")
 *  
 *  - 확장된 어노테이션
 * 		-> 클래스가 어느 레이어에 배치될지 고려해서 배치될 레이어에 있는 @Component 확장 어노테이션을 사용할 것.
 * 			(1) @Controller : 프레젠테이션 층 스프링 MVC용 어노테이션
 * 			(2) @Service : 비지니스 로직 층 Service용 어노테이션으로, @Component와 동일
 *  		(3) @Repository : 데이터 액세스 층의 DAO용 어노테이션
 *  		(4) @Configuration : Bean 정의를 자바 프로그램에서 실행하는 JavaConfig용 어노테이션  
 */
@Component
public class ProductDaoImp implements ProductDao {

	//Dao를 간단하게 구현하기 위해서 데이터베이스 엑세스는 하지 않는다.
	//대신 storage(Map)으로 데이터베이스 접근을 대체한다.
	private Map<String, Product> storage = new HashMap<String, Product>();
	
	/**
	 * 상품을 등록한다.
	 */
	@Override
	public void addProduct(Product product) {
		storage.put(product.getName(), product);
	}

	/**
	 * 이름으로 상품을 검색한다.
	 */
	@Override
	public Product findByProductName(String name) {
		return storage.get(name);
	}

} //end class