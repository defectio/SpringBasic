package com.defectio.spring.spring_02_di.sec01_xml.part01_basic;

/**
 * MySql 구현 클래스
 * @author defec
 *
 */
public class MysqlImp implements Service{
	
	// 기본생성자로 MysqlImp이 생성되면 "Mysql constructor 생성" 출력됨
	// ApplicationContext(컨테이너) 생성시, di.xml에 정의된 bean 설정에 의해 MysqlImp 기본 생성자 호출됨
	public MysqlImp() {
		System.out.println("Mysql constructor 생성");
	}
	
	@Override
	public void prn() {
		System.out.println("Mysql prn 호출됨.");
	}

}