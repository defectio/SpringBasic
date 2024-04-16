package com.defectio.spring.spring_03_aop.sec01_xml.part01_basic;

/**
 * 핵심로직만 구현해 놓은  클래스 - 핵심기능의 관점
 * @author defec
 *
 */
public class ServiceImp implements Service{

	public ServiceImp() {}

	@Override
	public void prn1() {
		System.out.println("prn1");
	}

	@Override
	public void prn1(int x) {
		System.out.println("prn1호출. x :" +x);
	}

	@Override
	public void prn1(int a, int b) {
		System.out.printf("prn1호출. a=%d b=%d\n", a, b);
	}

	@Override
	public void prn2() {
		System.out.println("prn2 호출");
	}

	@Override
	public String prn3() {
		System.out.println("prn3 호출");
		return "홍길동";
	}

	//예외 발생하지 않는 prn4() 메소드
	/*@Override
	public void prn4() {
		System.out.println("prn4");
	}*/
	
	// after-throwing을 위해 일부로 예외 발생
	@Override
	// throw Exception을 선언하여, 메소드 호출 부분에서 try, catch로 예외처리 강제 할 수도 있음
	//	public void prn4() throws Exception {
	public void prn4() {
		System.out.println("prn4 호출");
		String data = "abcd";
		//String을 int로 변환하려고 함. -> NumberFormatException 발생
		int num = Integer.parseInt(data); 
	}

	@Override
	public void prn5() {  //핵심로직 수행 후 다시 공통로직으로 넘어가야함.
		System.out.println("prn5");
		String data = "abcd";
		int num = Integer.parseInt(data); 
	}
	
}  //end class
