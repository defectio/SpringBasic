package com.defectio.spring.spring_04_jdbc.sec05_employees;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

public class EmpDaoImp implements EmpDAO{
	
	private SqlSessionTemplate sqlSession;
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	/**
	 * 월급 5위~10위에 해당하는 employee 목록을 출력한다.
	 */
	@Override
	public List<EmpDTO> searchEmpBySal(HashMap<String, Integer> map) {		
		return sqlSession.selectList("emp.search", map);
	}
	
}