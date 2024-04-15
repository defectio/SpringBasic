package com.defectio.spring.spring_01_basic.simple03;

/**
 * - interface 왜 사용하지? : 구현단계 전에 사용함(기획단계 or 설계단계)
 * - 표준명세서를 정의(규정)하기 위해서 사용한다. -> 공통된 기능을 가진 메소드의 이름을 통일(by 추상메소드로 명세부만) 하기 위해서 ex. 타이어 규격
 * - 클래스간의 상속관계는 관련 있는 객체들만 상속을 받을 수 있다.
 * 	   ex)  동물-포유류-호랑이, 토끼, 사자   식물-나무-은행나무, 소나무
 *         => 호랑이(객체)가 식물(객체)을 상속받을 수 없음. 서로 관련이 없기 때문..
 *            but, 관련 없는 객체들이 상속을 받아야 할 때 interface 사용한다.  
 */
public interface MessageBean {
	
	//추상메소드 -> Override 해야함.
	public void sayHello(String name);

}  //end interface
