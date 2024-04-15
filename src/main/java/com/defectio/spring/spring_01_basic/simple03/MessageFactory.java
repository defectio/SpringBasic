package com.defectio.spring.spring_01_basic.simple03;

/**
 *  Factory에서 인터페이스를 구현한 클래스를 객체로 생성
 * @author defec
 *
 */
public class MessageFactory {
	
	//정적메소드 -> 클래스명으로 직접 접근 가능
	public static MessageBean getInstance(String lang) {
		// factory에서 구현 객체(MessageBeanKorean, MessageBeanEnglish) 생성
		//  -> 다른 곳에서 MessageFactory.getInstance() 메소드를 가져다 쓰는 방식
		//  -> String 매개변수에 따라 MessageBeanKorean객체 or MessageBeanEnglish객체를 리턴함
		if (lang.equals("ko")) {
			return new MessageBeanKorean();
		} else if (lang.equals("en")) {
			return new MessageBeanEnglish();
		} else {
			return null;
		}
	} //end getInstance
	
} //end class
