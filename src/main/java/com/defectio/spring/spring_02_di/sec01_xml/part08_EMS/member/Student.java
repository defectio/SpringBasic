package com.defectio.spring.spring_02_di.sec01_xml.part08_EMS.member;

/**
 * 학생 정보
 * @author defec
 *
 */
public class Student {

	private String sNum;	// 학번
	private String sId;
	private String sPw;
	private String sName;
	private int sAge;
	private char sGender;
	private String sMajor;

	/**
	 * 생성자에서 필드 초기화에 필요한 모든 값을 받는다.
	 * @param sNum
	 * @param sId
	 * @param sPw
	 * @param sName
	 * @param sAge
	 * @param sGender
	 * @param sMajor
	 */
	public Student(String sNum, String sId, String sPw, String sName, int sAge, char sGender, String sMajor) {
		this.sNum = sNum;
		this.sId = sId;
		this.sPw = sPw;
		this.sName = sName;
		this.sAge = sAge;
		this.sGender = sGender;
		this.sMajor = sMajor;
	}

	// 각 필드별 getter/setter 메소드 구현
	public String getsNum() {
		return sNum;
	}

	public void setsNum(String sNum) {
		this.sNum = sNum;
	}

	public String getsId() {
		return sId;
	}

	public void setsId(String sId) {
		this.sId = sId;
	}

	public String getsPw() {
		return sPw;
	}

	public void setsPw(String sPw) {
		this.sPw = sPw;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public int getsAge() {
		return sAge;
	}

	public void setsAge(int sAge) {
		this.sAge = sAge;
	}

	public char getsGender() {
		return sGender;
	}

	public void setsGender(char sGender) {
		this.sGender = sGender;
	}

	public String getsMajor() {
		return sMajor;
	}

	public void setsMajor(String sMajor) {
		this.sMajor = sMajor;
	}

}