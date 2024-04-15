package com.defectio.spring.spring_02_di.sec02_annotation.part04_example;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class ServiceImp implements Service {
	
	
//	@Autowired
//	@Qualifier("userDTO")  // qualifier 태그가 없으면 id로 찾는다.

	//	@Resource(name="user")		//id가 user인 bean 객체를 찾아서 주입한다.
	private User user;
	
	public ServiceImp() {}
	
	@Autowired
	public ServiceImp(@Qualifier("userDTO") User user) {
		this.user = user;
	}
	
//	@Resource
	public void setUser(@Qualifier("userDTO") User user) {
		this.user = user;
	}

	@Override
	public void prn() {
		System.out.printf("name:%s pass:%s\n", user.getId(), user.getPass());
	}
	
}
