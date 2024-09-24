package com.defectio.spring.spring_02_di.sec02_annotation.part02_Resource;

/**
 * Animal 인터페이스를 구현한 Cat
 */
public class Cat implements Animal {
	
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void sound() {
		System.out.println("Cat Name = "+name+ " : 야옹");
	}

} //end class