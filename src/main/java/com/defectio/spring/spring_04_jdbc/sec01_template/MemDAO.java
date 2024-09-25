package com.defectio.spring.spring_04_jdbc.sec01_template;

import java.util.List;


/**
 * DAO(Data Access Object) : DB 데이터에 접근하는 객체
 *  - DAO는 Service와 DB를 연결하는 역할을 하며, 실제 DB에 접근하여 data를 삽입, 삭제, 조회, 수정 등 CRUD 기능을 수행한다.
 */
public interface MemDAO {
	
	public List<MemDTO> selectList();
	
	public void insertMethod(MemDTO dto);
	
	public void updateMethod(MemDTO dto);
	
	public void deleteMethod(int num);
	
	public MemDTO select(int num);
	
	public int countMethod();
	
}