package com.defectio.spring.spring_04_jdbc.sec06_product;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.defectio.spring.spring_02_di.XmlUtils;

public class SpringTest {

	public static void main(String[] args) {
		String pkgName = XmlUtils.getPackageName(SpringTest.class);
		String path = pkgName + "/jdbc.xml";

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(path);
		
		ProductDao dao = context.getBean("dao", ProductDao.class);
		
		//상품 등록
//		dao.insertProduct(new ProductDTO(1, "새우깡", 10, 1000, "농심"));
//		dao.insertProduct(new ProductDTO(2, "신라면", 20, 800, "농심"));

		//상품검색
//		ProductDTO dto = dao.searchProduct("새우깡");
//		if(dto != null) {
//			System.out.println("상품id\t\t이름\t\t수량\t가격\t\t제조회사");
//			System.out.println(dto.getId()+"\t\t"+dto.getName()+"\t\t"+dto.getQty()+"\t"+dto.getPrice()+"\t\t"+dto.getCompany());
//		} else {
//			System.out.println("해당상품은 없습니다.");
//		}
		
		//상품 개수 수정
//		dao.updateProduct(new ProductDTO("신라면", 15));
		
		//상품삭제하기
//		dao.deleteProduct("신라면");
		
		//상품전체개수
		int count = dao.countProduct();
		System.out.println("전체 상품 개수 : "+count);
		System.out.println();
		
		//상품리스트
		List<ProductDTO> list = dao.selectListProduct();
		
		System.out.println("[전체 상품 목록]");
		System.out.println("상품id\t\t이름\t\t수량\t가격\t\t제조회사");
		for(ProductDTO product : list) {
			System.out.println(product.getId()+"\t\t"+product.getName()+"\t\t"+product.getQty()+"\t"+product.getPrice()+"\t\t"+product.getCompany());
		}
	}

}