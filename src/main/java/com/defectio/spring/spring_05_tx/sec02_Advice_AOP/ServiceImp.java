package com.defectio.spring.spring_05_tx.sec02_Advice_AOP;

public class ServiceImp implements Service{
	
	private MemDAO dao;
	
	public ServiceImp() {}
	
	public void setDao(MemDAO dao) {
		this.dao = dao;
	}	
	
	/**
	 * ㅇ 트랜잭션이 선언된 메소드에서는 try-catch 블록 구현하지 않는다.
	 * ㅇ throws Exception으로 예외를 던져, 해당 메소드를 호출하는 곳에서 try~catch 블록을 구현하도록 한다.
	 *   - 트랜잭션처리 시 에러 발생하면 롤백된다. -> <tx:method rollback-for="">에 선정됨.
	 */
	@Override
	public void insertProcess() throws Exception {
//		dao.insertMethod(new MemDTO(7, "김사부", 50, "경기"));
		dao.insertMethod(new MemDTO(8, "존레논", 30, "대전"));
	}
	
	@Override
	public void updateProcess() throws Exception {}
	
}