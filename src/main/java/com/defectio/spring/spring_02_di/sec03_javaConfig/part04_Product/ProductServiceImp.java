package com.defectio.spring.spring_02_di.sec03_javaConfig.part04_Product;

public class ProductServiceImp implements ProductService {

	private ProductDao productDao;

	public ProductServiceImp() {}
	
	public ProductServiceImp(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	@Override
	public void addProduct(Product product) {
		productDao.addProduct(product);
	}

	@Override
	public Product findByProductName(String name) {
		return productDao.findByProductName(name);
	}

}
