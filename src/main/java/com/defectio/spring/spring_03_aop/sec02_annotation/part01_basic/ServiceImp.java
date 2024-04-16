package com.defectio.spring.spring_03_aop.sec02_annotation.part01_basic;

//핵심로직만 구현해 놓은  클래스 - 핵심기능의 관점
public class ServiceImp implements Service{

	public ServiceImp() {}

	/* 오버라이딩 메소드 */
	@Override
	public void prn1() {
		System.out.println("prn1 메소드 실행");
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

	//핵심로직실행 -> 공통로직실행 구현할때 어떤 값을 넘겨줄 경우
	@Override
	public String prn3() {
		System.out.println("prn3호출");
		return "홍길동";
	}

	//예외 발생하지 않는 prn4() 메소드
	/*@Override
	public void prn4() {
		System.out.println("prn4");
	}*/
	
	//after-throwing을 위해 일부로 예외 발생
	@Override
	public void prn4() {
		System.out.println("prn4");
		String data = "abcd";
		//String을 int로 변환하려고 함. -> NumberFormatException 발생
		int num = Integer.parseInt(data);
	}

	@Override
	public void prn5() {  //핵심로직 수행 후 다시 공통로직으로 넘어가야함.
		System.out.println("prn5");
	}
	
}  //end class
