package com.defectio.spring.spring_02_di.sec02_annotation.part01_Autowired;

import org.springframework.beans.factory.annotation.Autowired;

public class PetOwner {

	/** 
	 * @Autowired
	 *   - 빈 설정 파일(animal.xml)에서 "타입"에 맞는 bean 객체를 찾아 주입한다.
	 *   - 필드, 생성자, 메서드에서 사용 가능
	 *   - Animal 인터페이스 타입에 맞는 bean을 찾아 주입한다. -> Animal은 인터페이스이므로 구현 객체(Dog, Cat)들 모두 주입될 수 있다.
	 *   - Bean 설정 파일에서 Animal 타입(Dog, Cat 포함)으로 선언된 bean 객체가 하나 밖에 없으면 자동으로 주입됨.
	 */
	
	/**
	 * [@Autowired 적용 순서]
	 *  (1) 타입이 같은 bean 객체를 빈 설정 파일에서 검색한다.
	 * 	      @Qualifier가 있을 경우 Qualifier Value 까지 같은 객체를 찾는다.
	 *  (2) 타입이 같은 객체가 2개 이상이면, @Qualifier가 지정한 bean 객체를 찾는다.
	 *  (3) 타입이 같은 객체가 2개 이상이고, @Qualifier가 지정되어 있지 않으면, 필드명과 id가 같은 bean 객체를 찾는다.
	 *	 Animal 타입이 없다면 변수명과 id가 같은 빈 객체를 주입한다.  
	 */
	
//	@Autowired -> context.getBean("petOwner")로 가져올 수 없음. NullPointerException
	@Autowired  // animal.xml에서 Animal 타입으로 선언된 bean 객체를 자동 주입
//	@Autowired(required=false)  // -> 주입 대상 Bean 객체가 없더라도 오류 발생시키지 않음. Bean객체가 있다면 자동 주입됨 
//	@Nullable
	private Animal animal;
	
	public PetOwner() {

	}
	
//	@Autowired  // 생성자에 사용 가능
	public PetOwner(Animal animal) {
		this.animal = animal;
	}
	
//	@Autowired  // 메소드에 사용 가능
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
	/**
	 *  Animal 타입의 sound() 메소드 호출 
	 *  Animal 인터페이스를 구현한 모든 객체가 대입될 수 있음
	 *  주입되는 구현 객체에 따라 호출 결과가 달라짐
	 */
	public void play() {
		if (this.animal != null) {
			animal.sound();
		} else {
			System.out.println("animal 객체가 없습니다.");
		}
	}
	
} //end class
