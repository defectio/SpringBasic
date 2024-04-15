package com.defectio.spring.spring_02_di.sec03_javaConfig.part04_Product;

import java.util.HashMap;
import java.util.Map;

public class ProductDaoImp implements ProductDao {

	/**
	 * 상품정보 DB
	 */
	private Map<String, Product> storage = new HashMap<String, Product>();
	
	@Override
	public void addProduct(Product product) {
		storage.put(product.getName(), product);
	}

	@Override
	public Product findByProductName(String name) {
		return storage.get(name);
	}

}
