package com.defectio.spring.spring_05_tx.sec02_Advice_AOP;

/**
 * 트랜잭션 설정 interface
 * @author USER
 */
public interface Service {
	
	/**
	 * 추상메소드 선언부에서 <tx:method rollback-for=""> 에 선언한 예외로 throws를 명시
	 *  - 메소드를 호출하는 곳에서 "컴파일러"가 자동으로 예외처리를 하도록 체크
	 *  - surround try-catch 블록 선택하여 try~catch 구현
	 */

	public void insertProcess() throws Exception;
	
	public void updateProcess() throws Exception;

}