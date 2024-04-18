package com.defectio.spring.spring_02_di.sec02_annotation.part01_Autowired;

/**
 * Animal 인터페이스를 구현한 Dog
 */
public class Dog implements Animal{

	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void sound() {
		System.out.println("Dog Name = "+name+ " : 멍멍");
	}
	
} //end class