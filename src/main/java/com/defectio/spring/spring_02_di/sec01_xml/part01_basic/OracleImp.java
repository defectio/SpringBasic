package com.defectio.spring.spring_02_di.sec01_xml.part01_basic;

/**
 * Oracle 구현클래스
 * @author defec
 *
 */
public class OracleImp implements Service{
	
	// 기본생성자로 OracleImp이 생성되면 oracle constructor 출력됨
	// ApplicationContext(컨테이너) 생성시, di.xml에 정의된 bean 설정에 의해 OracleImp 기본 생성자 호출됨
	public OracleImp() {
		System.out.println("oracle constructor 생성");
	}
	
	@Override
	public void prn() {
		System.out.println("oracle prn 호출됨");
	}
	
}