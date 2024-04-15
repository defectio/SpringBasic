package com.defectio.spring.spring_02_di.sec02_annotation.part06_Component;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductRun {

	public static void main(String[] args) {
		String path = "sec02_annotation/part06_Component/di.xml";
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(path);
		
		ProductService svc = ctx.getBean(ProductService.class);
		
		//storage에 저장
		svc.addProduct(new Product("공책", 1000));
		
		//"공책"을 storage에서 검색
		Product product = svc.findByProductName("공책");
		System.out.println(product);
		
		ctx.close();
	} //end main

} //end class
