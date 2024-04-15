package com.defectio.spring.spring_02_di.sec02_annotation.part03_Qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class PetOwner {
	
	/**
	 * [@Autowired 적용 순서]
	 *  (1) 타입이 같은 bean 객체를 빈 설정 파일에서 검색한다.
	 * 	      @Qualifier가 있을 경우 Qualifier Value 까지 같은 객체를 찾는다.
	 *  (2) 타입이 같은 객체가 2개 이상이면, @Qualifier가 지정한 bean 객체를 찾는다.
	 *  (3) 타입이 같은 객체가 2개 이상이고, @Qualifier가 지정되어 있지 않으면, 변수명과 id같은 bean 객체를 찾는다.
	 */
	@Autowired  
	
	/**
	 * @Qualifier
	 * 
	 *  방법1) bean 설정파일에 선언한 bean 객체의 id값
	 * 	  	 - value에 지정된 값을 찾아 주입한다.(animal.xml에서 id가 cat인 빈이 주입됨)
	 *  방법2) bean 설정 파일에 qualifer 태그 추가
	 * 		 <qualifier value="qf_dog"></qualifier>
	 */
//	@Qualifier(value="cat")   	//[방법1] bean 설정 파일의 id값
//	@Qualifier("cat")
	
//	@Qualifier(value="qf_dog")	//[방법2] bean에 선언한 qualifier에 지정한 value값
	@Qualifier("qf_dog")
	private Animal animal;
	
	public void play() {
		animal.sound();
	}
	
} //end class