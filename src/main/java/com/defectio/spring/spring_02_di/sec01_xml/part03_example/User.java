package com.defectio.spring.spring_02_di.sec01_xml.part03_example;

/**
 * DTO
 * @author defec
 *
 */
public class User {
	private String id;
	private String pass;
	
	/* 생성자 */
	public User() {
		System.out.println("기본생성자 생성");
	}
	public User(String id, String pass) {
		this.id = id;
		this.pass = pass;
		//System.out.println("di.xml의 user 빈 생성됨.");
	}
	
	// field getter, setter
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
