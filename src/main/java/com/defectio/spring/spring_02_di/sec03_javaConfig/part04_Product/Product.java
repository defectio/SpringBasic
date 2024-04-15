package com.defectio.spring.spring_02_di.sec03_javaConfig.part04_Product;

public class Product {

	private String name;  //상품이름
	private int price;        //상품가격
	
	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return "Product [name="+this.name+", price="+this.price+"]";
	}
	
}
