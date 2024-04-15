package com.defectio.spring.spring_02_di.sec01_xml.part08_EMS.member.service;

import com.defectio.spring.spring_02_di.sec01_xml.part08_EMS.member.Student;
import com.defectio.spring.spring_02_di.sec01_xml.part08_EMS.member.dao.StudentDao;

/**
 * DB에 등록되어 있는 학생 정보를 수정한다.
 * @author defec
 *
 */
public class StudentModifyService {

	private StudentDao studentDao;

	/**
	 * 생성자로 의존성 주입 : <constructor-arg>
	 * @param studentDao
	 */
	public StudentModifyService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	/**
	 * DB에 등록되어 있는 학생만 정보를 수정할 수 있다.
	 * @param sNum
	 * @return
	 */
	public void modify(Student student) {
		if (verify(student.getsNum())) {
			studentDao.update(student);
		} else {
			System.out.println("Student information is not available.");
		}
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