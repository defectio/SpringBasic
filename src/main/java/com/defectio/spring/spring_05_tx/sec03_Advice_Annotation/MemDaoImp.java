package com.defectio.spring.spring_05_tx.sec03_Advice_Annotation;

import org.mybatis.spring.SqlSessionTemplate;

public class MemDaoImp implements MemDAO{
	
	private SqlSessionTemplate sqlSession;
	
	public MemDaoImp() {}
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public void insertMethod(MemDTO dto) {
		sqlSession.insert("mem.insert", dto);
	}
	
}