package com.defectio.spring.spring_02_di.sec01_xml.part04_property;

import java.util.Random;

public class ServiceImp implements Service{
	//필드
	private String name;
	private Random ran;
	
	/* 생성자 */
	public ServiceImp() {}

	
	/*
	 * 매개변수가 2개인 생성자 없음
	 * public ServiceImp(String name, Random ran) { 
	 * 		this.name = name; 
	 * 		this.ran = ran; 
	 * }
	 */

	/* setter */
	//di.xml에서 property를 이용해서 의존관계를 설정하려면 setter메소드가 있어야 한다.
	public void setName(String name) {
		this.name = name;
	}
	public void setRan(Random ran) {
		this.ran = ran;
	}
	
	/* 메소드 오버라이딩 */
	@Override
	public void prn1() {
		System.out.println("name : " +name);
	}
	
	@Override
	public void prn2() {
		System.out.println("ran : " +ran.nextInt());
		//난수값은 메소드 호출할때 생성됨(nextInt() 호출시 생성됨)
	}
	
	@Override
	public void prn3() {
		System.out.println("name : "  + name + ", ran : " + ran.nextInt());
	}
	
}  //end class
