package com.defectio.spring.spring_04_jdbc.sec01_template;

/**
 * hr.mem 테이블 사용
 * @author USER
 * 
 * [참고]https://ijbgo.tistory.com/9
 */
public class MemDTO {
	// 멤버변수명은 DB테이블의 컬럼명과 동일하게 선언해야 한다.
	private int num;
	private String name;
	private int age;
	private String loc;
	
	public MemDTO() {}
	
	public MemDTO(int num, String name) {
		this.num = num;
		this.name = name;
	}
	
	public MemDTO(int num, String name, int age, String loc) {
		this.num = num;
		this.name = name;
		this.age = age;
		this.loc = loc;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}
}