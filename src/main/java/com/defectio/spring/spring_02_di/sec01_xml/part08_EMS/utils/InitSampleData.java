package com.defectio.spring.spring_02_di.sec01_xml.part08_EMS.utils;

/**
 * 샘플데이터
 * @author defec
 *
 */
public class InitSampleData {

	/**
	 * 5명 학생 정보 샘플 데이터 -> applicationContext.xml에서 의존성 주입으로 변경
	 */
//	private String[] sNums = { "hbs001", "hbs002", "hbs003", "hbs004", "hbs005" };
//	private String[] sIds = { "rabbit", "hippo", "raccoon", "elephant", "lion" };
//	private String[] sPws = { "96539", "64875", "15284", "48765", "28661" };
//	private String[] sNames = { "agatha", "barbara", "chris", "doris", "elva" };
//	private int[] sAges = { 19, 22, 20, 27, 19 };
//	private char[] sGenders = { 'M', 'W', 'W', 'M', 'M' };
//	private String[] sMajors = { "English Literature", "Korean Language and Literature", "French Language and Literature", "Philosophy", "History"};	
	
	//applicationContext.xml 생성 후 코드 변경
	private String[] sNums;
	private String[] sIds;
	private String[] sPws;
	private String[] sNames;
	private int[] sAges;
	private char[] sGenders;
	private String[] sMajors;
	
	/**
	 * setter로 의존성 주입 : <property>
	 */
	
	// getter, setter 메소드
	public String[] getsNums() {
		return sNums;
	}

	public void setsNums(String[] sNums) {
		this.sNums = sNums;
	}

	public String[] getsIds() {
		return sIds;
	}

	public void setsIds(String[] sIds) {
		this.sIds = sIds;
	}

	public String[] getsPws() {
		return sPws;
	}

	public void setsPws(String[] sPws) {
		this.sPws = sPws;
	}

	public String[] getsNames() {
		return sNames;
	}

	public void setsNames(String[] sNames) {
		this.sNames = sNames;
	}

	public int[] getsAges() {
		return sAges;
	}

	public void setsAges(int[] sAges) {
		this.sAges = sAges;
	}

	public char[] getsGenders() {
		return sGenders;
	}

	public void setsGenders(char[] sGenders) {
		this.sGenders = sGenders;
	}

	public String[] getsMajors() {
		return sMajors;
	}

	public void setsMajors(String[] sMajors) {
		this.sMajors = sMajors;
	}

}