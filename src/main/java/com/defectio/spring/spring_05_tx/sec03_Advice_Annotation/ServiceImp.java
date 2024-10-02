package com.defectio.spring.spring_05_tx.sec03_Advice_Annotation;

import org.springframework.transaction.annotation.Transactional;

public class ServiceImp implements Service {
	
	private MemDAO dao;
	
	public ServiceImp() {}
	
	public void setDao(MemDAO dao) {
		this.dao = dao;
	}

	// Transactional 클래스 import
	@Transactional(rollbackFor=java.lang.Exception.class)
	@Override
	public void insertProcess() throws Exception{
		dao.insertMethod(new MemDTO(9, "최장군", 50, "경기"));
//		dao.insertMethod(new MemDTO(10, "조대위", 30, "대전"));
	}

}