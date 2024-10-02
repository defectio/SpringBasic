package com.defectio.spring.spring_05_tx.sec02_Advice_AOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.defectio.spring.spring_02_di.XmlUtils;

public class SpringTest {

	public static void main(String[] args) {
		String pkgName = XmlUtils.getPackageName(SpringTest.class);
		String path = pkgName + "/tx.xml";
		
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(path);
		
		Service svc = context.getBean("svc", Service.class);
		
		/**
		 * 트랜잭션이 적용된 메소드 호출 시 try-catch 구문으로 예외처리 해야한다.
		 */
		//[방법 1] 메소드에 throws Exception 미 선언시 개발자 직접 try-catch 구현
		//메소드를 호출하는 곳에서 try~catch를 구현해야 한다.
		//즉, Service에 트랜잭션이 설정된 메소드를 호출하는 Controller에서 try-catch 블록 구현!!!
		/*try {
			svc.insertProcess();
		} catch(Exception ex) {
			System.out.println(ex.toString());
		}*/  
		
		
		//[방법 2] 추상메소드(tx:advice를 설정한 메소드) 자체에 throws를 선언해서 호출시 "컴파일러가 체크"할 수 있도록 한다.
		//(1) Service의 insertProcess() 메소드에 throws Exception 선언
		//(2) ServiceImp에서 throws가 선언된 insertProcess() 재정의
		//(3) 호출시 컴파일러 체크 -> Surround with try/catch 블록으로 감싸기
		try {
			svc.insertProcess();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	
	}
	
}