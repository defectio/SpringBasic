package com.defectio.spring.spring_04_jdbc.sec03_SqlSessionTemplate;

import java.util.HashMap;
import java.util.List;

public interface MemDAO {  
	
	public List<MemDTO> selectList();
	
	public void insertMethod(MemDTO dto);
	
	public void updateMethod(MemDTO dto);
	
	public void deleteMethod(int num);
	
	public MemDTO select(int num);
	
	public int countMethod();
	
	public List<MemDTO> searchMethod(int num);
	
	public List<MemDTO> searchMethod(HashMap<String, Integer> map);
	
}