package com.defectio.spring.spring_03_aop.sec02_annotation.part02_timecheck;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * @Aspect
 * @author defec
 *
 */
@Aspect
public class StopWatchAspect {
	
	/**
	 * @Around 사용 -> prn() 메소드 호츨 전/후로 실행됨
	 * @param point
	 */
	@Around("execution(* sec02_annotation.part02_timecheck.ServiceImp.prn())")
	public void process(ProceedingJoinPoint point) {
		/**
		 *	prn() 메소드 호출 시 process() 메소드 즉시 실행
		 * 즉, prn() 호출된 시간
		 */
		long start = System.currentTimeMillis();
		
		// 핵심로직 실행 -> proceed()에 의해 prn() 메소드 실행
		try {
			point.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		/**
		 * 핵심로직 끝나고 공통로직으로 돌아온 시간
		 * 즉, prn() 메소드 수행 종료된 시간
		 */
		long end = System.currentTimeMillis();
		
		//end-start = prn() 메소드를 수행한 시간
		//getSignature() : 호출되는 메소드에 대한 정보를 구함
		//getName() : 메소드의 이름을 구함.
//		System.out.println(point);    //execution(void part03_timecheck.Service.prn())
//		System.out.println(point.getSignature());  //void part03_timecheck.Service.prn()
		
		String time = point.getSignature().getName() + "_메소드 실행시간 : " + (end - start);
		System.out.println(time + "밀리초");
	}
}
