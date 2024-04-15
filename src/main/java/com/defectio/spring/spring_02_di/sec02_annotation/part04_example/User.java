package com.defectio.spring.spring_02_di.sec02_annotation.part04_example;

/**
 * UserDTO
 * @author defec
 *
 */
public class User { 
	
	private String id;
	private String pass;
	
	// 생성자
	public User() {
		System.out.println("기본생성자 생성");
	}
	public User(String id, String pass) {
		this.id = id;
		this.pass = pass;
	}
	
	/* getter, setter */
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
}