package com.defectio.spring.spring_03_aop.sec01_xml.part01_basic;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 공통로직만 구현해 놓은 클래스 - 공통관점
 * @author defec
 */
public class AspectCommon {
	
	public AspectCommon() {}
	
	public void comm1() {
		System.out.println("comm1() before");
	}
	
	public void comm2()	 {
		System.out.println("comm2() after");
	}
	
	public void comm3(String name) {
		System.out.println("comm3 : " +name);
	}
	
	//prn4() 에서 예외가 발생하지않으면 실행 되지 않는다.
	public void comm4(Exception ex) {
		if(ex != null) {  //예외가 null이 아니다. 즉, 예외가 발생하면~
			System.out.println(ex.toString());
		}
		System.out.println("핵심로직 실행 중 예외가 발생하여 comm4가 호출됨");
	}
	
	/**
	 * 핵심로직을 구현해 놓은 빈(클래스) : Target
	 * Target에 구현된 메소드 : JoinPoint
	 * JoinPoint에 실행해야될 위치 : Pointcut
	 * 
	 */
	
	// 공통로직을 실행하다 핵심로직으로 넘어가는 시점에 proceed 메소드 호출
	// import : ProceedingJoinPoint
	public void comm5(ProceedingJoinPoint point) {
		System.out.println("comm5 start");		
		try {
			/**
			 * proceed가 호출되면서 권한이 핵심로직으로 넘어감. prn5 가 실행되어야함
			 * proceed() : 반드시 예외처리해야한다.(surround...)
			 */
			point.proceed();
		} catch (Throwable e) {
			System.out.println(e.toString());
		}
		
		/**
		 *  - prn5가 실행-종료되면 다시 공통로직으로 권한이 넘어옴.
		 *  - prn5() 메소드 실행 시 예외가 발생하더라도 catch문 이후의 comm5 로직은 실행됨
		 * 
		 */
		System.out.println("comm5 end");
	}
	
}
