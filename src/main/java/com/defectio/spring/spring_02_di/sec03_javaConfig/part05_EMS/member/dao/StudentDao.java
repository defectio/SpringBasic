package com.defectio.spring.spring_02_di.sec03_javaConfig.part05_EMS.member.dao;

import java.util.HashMap;
import java.util.Map;

import com.defectio.spring.spring_02_di.sec03_javaConfig.part05_EMS.member.Student;

/**
 * 일반적인 DAO(database access object) 클래스
 *  -> 데이터베이스에 접속하고, service에 의해 호출되며,
 *     데이터의 insert, search, update, delete 등의 기능을 수행한다.
 * @author defec
 */
public class StudentDao {

	/**
	 * DB를 대신하여 HashMap 사용 -> 추후에 mariaDB 사용 예정
	 */
	private Map<String, Student> studentDB = new HashMap<String, Student>();

	
	/**
	 * DB insert 메소드
	 * @param student
	 */
	public void insert(Student student) {
		studentDB.put(student.getsNum(), student);
	}

	/**
	 * DB search 메소드
	 * @param sNum
	 * @return
	 */
	public Student select(String sNum) {
		return studentDB.get(sNum);
	}

	/**
	 * DB update 메소드
	 * @param student
	 */
	public void update(Student student) {
		studentDB.put(student.getsNum(), student);
	}

	/**
	 * DB delete 메소드
	 * @param sNum
	 */
	public void delete(String sNum) {
		studentDB.remove(sNum);
	}

	/**
	 * DB에 있는 정보 리턴
	 * @return
	 */
	public Map<String, Student> getStudentDB() {
		return studentDB;
	}

}