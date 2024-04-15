package com.defectio.spring.spring_02_di.sec03_javaConfig.part04_Product;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProductRun {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		ProductService svc = ctx.getBean(ProductService.class);
		
		// storage에 저장
		svc.addProduct(new Product("공책", 1000));
		
		// 공책 검색
		Product product = svc.findByProductName("공책");
		System.out.println(product);

	} //end main

} //end class