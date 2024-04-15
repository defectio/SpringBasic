package com.defectio.spring.spring_02_di.sec02_annotation.part03_Qualifier;

public class Cat implements Animal {

	private String name;

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void sound() {
		System.out.println("Cat Name = " + name + " : 야옹");
	}

} // end class