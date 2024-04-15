package com.defectio.spring.spring_02_di.sec01_xml.part08_EMS.member.dao;

import java.util.HashMap;
import java.util.Map;

import com.defectio.spring.spring_02_di.sec01_xml.part08_EMS.member.Student;

/**
 * DAO(database access object) 클래스
 *  -> 데이터베이스에 접속하고, service에 의해 호출되며,
 *     데이터의 insert, search, update, delete 등의 기능을 수행한다.
 *  -> service에서 DAO의 메소드를 호촐하여 DB에 접근(select 등 DML)한다
 * @author defec
 *
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
	 * DB search 메소드(학번으로 검색)
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
	 * DB에 있는 학생 전체 정보 리턴
	 * @return
	 */
	public Map<String, Student> getStudentDB() {
		return studentDB;
	}

}