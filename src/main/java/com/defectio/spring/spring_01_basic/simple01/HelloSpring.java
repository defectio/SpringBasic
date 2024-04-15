package com.defectio.spring.spring_01_basic.simple01;

/**
 * [결합도]
 *  1. 클래스간의 상호 연결성 측정을 의미한다.
 *  2. 낮은 결합도를 가지려면 하나의 객체변경이 다른객체에 영향을 미쳐서는 안된다.
 */

public class HelloSpring {
	
	public static void main(String[] args) {
		//MessageBean객체(클래스)를 직접생성한다.
		//MessageBean객체(클래스)를 직접적으로 사용하기 때문에 결합도가 가장 높다.(가장 높은 의존성)
		MessageBean bean = new MessageBean();
		bean.sayHello("홍길동");
	} //end main
	
} //end class