package com.defectio.spring.spring_02_di.sec02_annotation.part02_Resource;

import javax.annotation.Resource;

public class PetOwner {
	
	/**
	 * @Resource
	 *  - name 값을 넣어주면 해당 값을 bean들의 "id"값과 비교 하여 의존성을 주입한다.
	 *  - 생성자에는 적용할 수 없고, 필드나 메소드에만 적용가능하다.
	 *  - pom.xml에 javax.annotation-api dependency 추가
	 */
	
	/**
	 * [Resource 적용 순서]
	 *  (1) @Resource가 지정한 name과 id가 같은 bean 객체를 찾는다. -> 없으면 오류
	 *  (2) @Resource에 name 값을 지정하지 않을 경우, @Autowired 와 동일 
	 * 		(2-1) 타입이 같은 bean 객체를 찾는다.
	 *  	(2-2) 타입이 같은 객체가 2개 이상이면, 필드명과 같은 id 값을 가진 bean 객체를 찾는다.
	 *  (3) 그래도 못찾으면, @Qualifier가 지정한 객체를 찾는다.
	 */

	/**
	 *  @Resource vs @Autowired
	 *  - @Autowired 
	 *  		* 빈 설정 파일에 선언된 type으로 자동주입
	 *  		* 필드, 생성자, 메소드에 사용 가능
	 *  - @Resource
	 *  		* 빈 설정 파일에 선언된 name으로 자동주입
	 *  		* 필드, 메서드에 사용 가능(생성자 사용 불가능)
	 */
	
	//Resource에 name값을 지정하지 않았을 경우 -> Animal 타입의 bean 객체를 찾는다.
//	@Resource
	private Animal animal;

	public PetOwner() {
		// TODO Auto-generated constructor stub
	}
	
//	 @Resource(name="dog") // -> The annotation @Resource is disallowed for this location
	// 생성자에 @Resource 사용 불가
	public PetOwner(Animal animal) {
		this.animal = animal;
	}
	
	//빈 설정 파일에서 id가 cat인 빈 객체를 찾아서 주입한다. -> id가 cat인 bean객체가 없으면 오류 
	@Resource(name="cat")
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public void play() {
		animal.sound();
	}
	
} //end class