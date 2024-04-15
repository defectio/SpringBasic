package com.defectio.spring.spring_02_di.sec01_xml.part08_EMS.member.service;

import com.defectio.spring.spring_02_di.sec01_xml.part08_EMS.member.Student;
import com.defectio.spring.spring_02_di.sec01_xml.part08_EMS.member.dao.StudentDao;

/**
 * 학생 한 명의 정보를 검색한다.
 * @author defec
 *
 */
public class StudentSelectService {

	private StudentDao studentDao;

	/**
	 * 생성자로 의존성 주입 : <constructor-arg>
	 * @param studentDao
	 */
	public StudentSelectService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	/**
	 * DB에 등록된 학생만 학번으로 검색할 수 있다.
	 * @param sNum
	 * @return
	 */
	public Student select(String sNum) {
		if (verify(sNum)) {
			return studentDao.select(sNum);

		} else {
			System.out.println("Student information is available.");
		}

		return null;
	}

	/**
	 * DB에 이미 등록된 학생인지 판단 
	 * 등록되어 있는 학생 : true / 등록되지 않은 학생 : false
	 * @param sNum
	 * @return
	 */
	public boolean verify(String sNum) {
		Student student = studentDao.select(sNum);
		return student != null ? true : false;
	}

}