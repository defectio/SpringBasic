package com.defectio.spring.spring_04_jdbc.sec02_JdbcDaoSupport;

import java.util.List;

public interface MemDAO {
	
	public List<MemDTO> selectList();
	
	public void insertMethod(MemDTO dto);
	
	public void updateMethod(MemDTO dto);
	
	public void deleteMethod(int num)	;
	
	public MemDTO select(int num);
	
	public int countMethod();
	
}