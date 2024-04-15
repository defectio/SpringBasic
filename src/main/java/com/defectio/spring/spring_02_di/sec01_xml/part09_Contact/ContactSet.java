package com.defectio.spring.spring_02_di.sec01_xml.part09_Contact;

/**
 * 연락처 정보DB
 * 
 * @author defec
 *
 */
public class ContactSet {

	private String name;
	private String phoneNumber;

	/**
	 * 필드 초기화에 필요한 모든 값을 인자로 받는 생성자
	 * 
	 * @param name
	 * @param phoneNumber
	 */
	public ContactSet(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
