package com.defectio.spring.spring_02_di.sec02_annotation.part06_Component;

public interface ProductService {

	public void addProduct(Product product);

	public Product findByProductName(String name);

} // end interface
