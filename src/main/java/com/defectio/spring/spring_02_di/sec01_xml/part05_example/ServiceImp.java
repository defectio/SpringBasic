package com.defectio.spring.spring_02_di.sec01_xml.part05_example;

public class ServiceImp implements Service{
	
	//ServiceImp에서 MemDaoImp를 이용하려고 함. -> ServiceImp에 MemDaoImp를 주입해야함(DI)
	private MemDaoImp memDao;
	
	public ServiceImp() {}
	
	// setter로 의존성 주입-> property 태그 사용
	public void setMemDao(MemDaoImp memDao) {
		this.memDao = memDao;
	}
	
	@Override
	public void prn1() {
		// 레코드 출력
		memDao.selectMethod();
	}
	@Override
	public void prn2() {
		// 레코드 삽입
		memDao.insertMethod();
	}
	
}  //end class
