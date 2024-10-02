package com.defectio.spring.spring_04_jdbc.sec06_product;

import java.util.List;

public interface ProductDao {

	//상품등록
	public void insertProduct(ProductDTO dto);
	
	//상품전체리스트 가져오기
	public List<ProductDTO> selectListProduct();
	
	//상품 검색하기
	public ProductDTO searchProduct(String name);
	
	//상품 삭제하기
	public void deleteProduct(String name);
	
	//상품 개수
	public int countProduct();
	
	//상품수량 수정하기
	public void updateProduct(ProductDTO dto);
}
