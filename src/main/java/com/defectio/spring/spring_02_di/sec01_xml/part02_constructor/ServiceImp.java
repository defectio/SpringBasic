package com.defectio.spring.spring_02_di.sec01_xml.part02_constructor;

import java.util.Random;

public class ServiceImp implements Service{
	//멤버변수
	private String name;
	private int age;
	private String dept;
	private Random ran;

	/* 생성자 */
	//기본 생성자
	public ServiceImp() {
		System.out.println("기본생성자에 의한 ServiceImp 생성");
	}
	//인자값이 name인 생성자
	public ServiceImp(String name) {
		this.name = name;
	}
	//인자값이 age, dept 인 생성자
	public ServiceImp(int age, String dept) {
		this.age = age;
		this.dept = dept;
	}
	//인자값이 ran인 생성자 -> 참조타입으로 생성
	public ServiceImp(Random ran) {
		this.ran = ran;
	}
	
	/* 메소드 오버라이딩 */
	@Override
	public void prn1() {
		System.out.println("name : " +name);
	}
	@Override
	public void prn2() {
		System.out.printf("age:%d, dept:%s\n", age, dept);
	}
	@Override
	public void prn3() {
		System.out.println("random : " +ran.nextInt());
	}

}  //end class
