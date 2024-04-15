package com.defectio.spring.spring_02_di.sec03_javaConfig.part05_EMS.member.service;

import com.defectio.spring.spring_02_di.sec03_javaConfig.part05_EMS.member.Student;
import com.defectio.spring.spring_02_di.sec03_javaConfig.part05_EMS.member.dao.StudentDao;

/**
 * DB에 등록된 학생을 삭제한다.
 * @author defec
 *
 */
public class StudentDeleteService {

	private StudentDao studentDao;

	public StudentDeleteService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	/**
	 * DB에 등록된 학생만 삭제할 수 있다.
	 * @param sNum
	 */
	public void delete(String sNum) {
		if (verify(sNum)) {
			studentDao.delete(sNum);
		} else {
			System.out.println("Student information is available.");
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