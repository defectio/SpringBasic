package com.defectio.spring.spring_03_aop.sec02_annotation.part01_basic;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 공통로직만 구현해 놓은 클래스 - 공통관점
 * @author defec
 */
@Aspect
public class AspectCommon {
	
	public AspectCommon() {}
	
	//pointcut에서 설정한 값을 여기에서 지정함.
    //@Before(value="execution(* part02_annotatin.ServiceImp.prn1(..))")  - 속성명이 1개일 때는 속성명 생략 가능
	@Before("execution(* sec02_annotation.part01_basic.ServiceImp.prn1(..))")
	public void comm1(JoinPoint jp) {
		System.out.println("comm1() before");
		
		Signature sig = jp.getSignature();
		System.out.println("\t---> 메서드 이름 : "+sig.getName());
		Object[] objs = jp.getArgs();
		if (objs.length == 0) {
			System.out.println("\t---> 인수값 : 없음");
		} else {
			for (Object obj : objs) {
				System.out.println("\t---> 인수값 : " + obj);
			}
		}
		
	}
	
	@After("execution(* sec02_annotation.part01_basic.ServiceImp.prn2(..))")
	public void comm2(JoinPoint jp)	 {
		System.out.println("comm2() after");
		
		org.aspectj.lang.Signature sig = jp.getSignature();
		System.out.println("\t---> 메서드 이름 : " + sig.getName());
		Object[] objs = jp.getArgs();
		if (objs.length == 0) {
			System.out.println("\t---> 인수값 : 없음");
		} else {
			for (Object obj : objs) {
				System.out.println("\t---> 인수값 : " + obj);
			}
		}
	}
	
	/**
	 *  속성명이 2개 이상일 경우 반드시 속성명을 지정해야 한다.
	 *  returningn : prn3()의 리턴값을 name으로 받겠다는 의미
	 * @param name
	 */
	@AfterReturning(value="execution(* sec02_annotation.part01_basic.ServiceImp.prn3(..))", returning="name")
	public void comm3(String name) {
		System.out.println("comm3 : " +name);
	}
	
	//예외발생 안하면 실행 안되는 메소드
	@AfterThrowing(value="execution(* sec02_annotation.part01_basic.ServiceImp.prn4(..))", throwing="ex")
	public void comm4(Exception ex) {  //exception이 발생하지 않으면 넘겨주는 값이 없음 -> null
		if(ex != null) {  //예외 발생하면
			System.out.println(ex.toString());   //예외 내용 표시
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
	@Around("execution(* sec02_annotation.part01_basic.ServiceImp.prn5(..))")
	public void comm5(ProceedingJoinPoint point) {
		System.out.println("comm5 start");		
		try {
			/**
			 *  - proceed가 호출되면서 권한이 핵심로직으로 넘어감. prn5 가 실행되어야함
			 *  - proceed() : 반드시 예외처리해야한다.(surround...)
			 */
			point.proceed(); 	//조인포인트 실행
		} catch (Throwable e) {
			e.printStackTrace();
		}		
		System.out.println("comm5 end");
	}
	
}