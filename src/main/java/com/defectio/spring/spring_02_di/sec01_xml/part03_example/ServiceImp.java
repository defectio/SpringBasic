package com.defectio.spring.spring_02_di.sec01_xml.part03_example;

public class ServiceImp implements Service {
	//필드(객체를 필드로 함)
	private User user;
	
	/* 생성자 */
	public ServiceImp() {
	
	}
	//user 객체가 들어오면 ServiceImp 생성됨 -> 생성자에 의한 의존성 주입
	public ServiceImp(User user) {
		this.user = user;
		System.out.println("service에 user 객체가 주입됨.");
	}
	
	@Override
	public void prn() {
		System.out.printf("name:%s pass:%s\n", user.getId(), user.getPass());
	}
	
}
