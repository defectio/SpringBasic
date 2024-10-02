package com.defectio.spring.spring_05_tx.sec01_TransactionTemplate;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * TransactionTemplate 사용 : tx.xml에서 의존성 주입 받음 
 * @author USER
 *
 */
public class ServiceImp implements Service {

	private MemDAO dao;
	private TransactionTemplate transactionTemplate;
	
	public ServiceImp() {}
	
	public void setDao(MemDAO dao) {
		this.dao = dao;
	}
	
	// 의존성 주입
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}
	
	/**
	 * [명시적 트랜잭션 적용]
	 *  - 트랜잭션 처리 안했을 경우, DB insert 중에 오류 발생 시 프로그램이 종료됨(에러처리 안됨)
	 *  - ex) ORA-00001: unique constraint (HR.MEM_NUM_PK) violated 발생.(ID 컬럼에 primary 제약 조건이 적용되어 있기 때문)
	 *    dao.insertMethod(new MemDTO(9, "이수박", 50, "인천"));
	 *    dao.insertMethod(new MemDTO(9, "최딸기", 30, "서울"));
	 */
	@Override
	public void insertProcess() {
		
		/**
		 * execute메소드의 매개변수로 익명구현객체가 대입됨
		 *  - TransactionCallback<T> 인터페이스의 추상메소드(doInTransaction)를 재정의
		 *  - TransactionCallback의 제네릭타입이 doInTransaction()의 리턴타입이 된다.
		 *  - 트랜잭션 실행문은 try ~ catch문에 작성한다.
		 */
		Object result = transactionTemplate.execute(new TransactionCallback<Object>() {

			@Override
			public Object doInTransaction(TransactionStatus status) {
				/**
				 * 트랜잭션 실패 시 rollback -> try 블록 이전으로 되돌림(하나도 insert안됨)
				 */
				try {
					// 트랜잭션 정상 실행용
					//dao.insertMethod(new MemDTO(8, "이수박", 50, "인천"));
					//dao.insertMethod(new MemDTO(9, "최딸기", 30, "서울"));
					
					/**
					 * 트랜잭션 오류 확인용 : insert 대기 상태(commit 이전)
					 */
					dao.insertMethod(new MemDTO(7, "이승우", 25, "인천")); 
					
					// primary key 중복으로 예외(DuplicateKeyException) 발생 -> catch구문의 setRollbackOnly()에 의해 try 구문 전체가 rollback됨
//					dao.insertMethod(new MemDTO(7, "박지성", 30, "서울"));
					
					return "ok";
				} catch(Exception e) {
					status.setRollbackOnly();
					return e.toString();
				}
			}
		});
		
		System.out.println("트랜잭션 결과 : "+result);
	}
	
}
