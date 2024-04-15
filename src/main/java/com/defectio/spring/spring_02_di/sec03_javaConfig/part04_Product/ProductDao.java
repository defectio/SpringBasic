package com.defectio.spring.spring_02_di.sec03_javaConfig.part04_Product;

public interface ProductDao {

	public void addProduct(Product product);

	public Product findByProductName(String name);
}
