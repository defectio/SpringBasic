package com.defectio.spring.spring_02_di.sec01_xml.part01_basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//컨테이너는 여러개 제공되는데 다 알 필요는 없고 다음 2개만 잘 알아 놓을 것.
//1. ApplicationContext : container 생성될 때(ApplicationContext 객체 생성 할 때) -> 설정파일에 있는 빈들이 실행됨(생성됨)
//2. WebApplicationContext : WAS(tomcat) 실행될 때 -> 설정파일에 있는 빈들이 실행됨.(생성됨)

/**
 * IOC(Inversion of Control) : 인스턴스의 생성 및 소멸 등의 생명주기와 사용범위 까지 개발자가 아닌 
 * Spring container가 관리 하는 등, 자원의 제어 역할이 개발자가 아닌 Container에게 역전되었음을 뜻함.
 * 
 * DL(Dependency Lookup) : 의존성 검색이란 뜻으로 컨테이너가 제공하는 API 함수로 필요한 Bean을 검색하여 사용하는 방식
 * 
 *  <기술면접대비>
 *  Bean : Spring IoC 컨테이너가 관리 하는 자바 객체를 bean(빈)이라고 부른다.
 * 	DI(Depedency Injection) : 의존성 주입이란 뜻으로 Bean 설정 정보를 이용해 IOC 컨테이너가 자동으로 객체를 연결 해주는 방식
 * 		- 의존관계주입(의존성 주입)이라는 뜻으로 쉽게 말해 객체(오브젝트) 사이의 의존관계를 만드는 것을 말함
 * 		   즉, 어떤 객체의 프로퍼티(인스턴스 변수, 필드)에 그 객체가 이용할 객체를 설정(주입)한다는 의미.
 * 		- 어떻게 주입 하는지? (1) Bean 설정 XML 파일
 * 										- 생성자
 * 										- setter
 * 				  				  (2) Bean Annotation 설정
 *   			  				  (3) java Config
 *  		- 왜 사용하는지? : 객체간의 결합도를 낮추기 위해서 사용함 -> 그로 인한 이점으로 ......유지보수 용이...??
 */

public class SpringTest {

	public static void main(String[] args) {
		// ClassPath 
		String path = "sec01_xml/part01_basic/di.xml";

		//ApplicationContext(컨테이너) 객체 생성(xml파일로 생성함)
		//		-> part01/di.xml에 설정된 빈들이 모두 생성됨.(빈 id가 mysql, oracle 인 빈들이 생성됨) 
		//MysqlImp, OracleImp 객체를 직접생성하지 않음(IoC, Inversion of Control) -> 객체 생성 및 주입을 개발자가 아닌 IoC 컨테이너에서 수행한다.
		ApplicationContext context = new ClassPathXmlApplicationContext(path);
		
		//context의 getBean() 메소드를 이용해서 id가 mysql인 빈을 가져옴(Service에 주입시킴)
		//Service svc  = new MysqlImp(); //<- 직접 인터페이스를 구현해서 사용하는 방식. 의존성 주입 아님.
		Service svc = (Service) context.getBean("mysql");  // return 타입이 Object -> Service 타입을 casting 해야함
		svc.prn();
		
		//context의 getBean() 메소드를 이용해서 id가 oracle인 빈을 가져옴(Service에 주입시킴)
		//Service svc = new OracleImp();
		svc = context.getBean("oracle", OracleImp.class);  // return 타입이 class 타입 -> casting 필요 없음.
		svc.prn();
	}

} //end class