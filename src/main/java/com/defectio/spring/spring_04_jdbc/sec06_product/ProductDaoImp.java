package com.defectio.spring.spring_04_jdbc.sec06_product;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

public class ProductDaoImp implements ProductDao {

	private SqlSessionTemplate sqlSession;
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public void insertProduct(ProductDTO dto) {
		sqlSession.insert("pro.insert", dto);
	}
	
	@Override
	public List<ProductDTO> selectListProduct() {
		return sqlSession.selectList("pro.list");
	}
	
	@Override
	public ProductDTO searchProduct(String name) {
		return sqlSession.selectOne("pro.search", name);
	}
	
	@Override
	public void deleteProduct(String name) {
		ProductDTO dto = searchProduct(name);
		if(dto != null) {
			//삭제
			sqlSession.delete("pro.delete", name);
		} else {
			System.out.println("해당 상품은 등록되어 있지 않습니다.");
		}
	}
	
	@Override
	public int countProduct() {
		return sqlSession.selectOne("pro.count");
	}
	
	@Override
	public void updateProduct(ProductDTO dto) {
		sqlSession.update("pro.update", dto);
	}
}
