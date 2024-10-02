package com.defectio.spring.spring_04_jdbc.sec06_product;

public class ProductDTO {

	private int id;
	private String name;
	private int qty;
	private int price;
	private String company;
	
	public ProductDTO() {}
	
	public ProductDTO(String name, int qty) {
		this.name = name;
		this.qty = qty;
	}
	
	public ProductDTO(int id, String name, int qty, int price, String company) {
		this.id = id;
		this.name = name;
		this.qty = qty;
		this.price = price;
		this.company = company;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
}