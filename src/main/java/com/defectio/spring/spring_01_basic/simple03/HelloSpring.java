package com.defectio.spring.spring_01_basic.simple03;

/**
 * [factory] 구현 방식
 *   - factory를 이용하면 결합도는 interface 보다 낮아지지만
 *   - factory가 정확히 구현되어 있지 않으면 참조하는 객체에 영향이 간다. 
 * @author defec
 *
 */
public class HelloSpring {

	public static void main(String[] args) {
		 
		/**
		 * Factory 방식은 Factory가 구현클래스를 생성하기 때문에 호출클래스에서는 Factory를 호출 하기만 하면 된다. 
		 * 구현클래스 변경시 Factory만 수정하면 되기 때문에 호출클래스에는 영향을 미치지 않는다. 
		 * 그러나 호출클래스에서는 Factory를 호출하는 코드가 들어가야 하는 것 또한 Factory에 의존한다는 의미이다.
		 * 호출클래스에서는 MessageBeanKorean, MessageBeanEnglish를 생성하는 것이 아니라 Factory에서 생성된 구현 클래스를 가져온다.
		 */
		MessageBean bean = MessageFactory.getInstance("ko");
		bean.sayHello("스프링");
		
		bean = MessageFactory.getInstance("en");
		bean.sayHello("spring");
	} //end main

}  //end class
