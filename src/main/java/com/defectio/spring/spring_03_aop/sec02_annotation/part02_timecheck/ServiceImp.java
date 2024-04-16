package com.defectio.spring.spring_03_aop.sec02_annotation.part02_timecheck;

/**
 *  prn()메소드가 실행된 시간 체크
 *  aop:around 사용(끝난 시간 - 시작한 시간)
 * @author defec
 *
 */
public class ServiceImp implements Service{
	
	public ServiceImp() {}

	@Override
	public void prn() {
		int sum = 0;
		for (int i = 0; i < 1000000; i++) {
			sum += i;
		}
		System.out.println("sum : " +sum);
	}  //end prn()

}  // end class

