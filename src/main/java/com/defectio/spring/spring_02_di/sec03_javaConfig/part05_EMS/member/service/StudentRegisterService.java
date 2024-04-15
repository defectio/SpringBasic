package com.defectio.spring.spring_02_di.sec03_javaConfig.part05_EMS.member.service;

import com.defectio.spring.spring_02_di.sec03_javaConfig.part05_EMS.member.Student;
import com.defectio.spring.spring_02_di.sec03_javaConfig.part05_EMS.member.dao.StudentDao;

/**
 * 학생 정보를 데이터베이스에 저장한다.
 * @author defec
 *
 */
public class StudentRegisterService {

	private StudentDao studentDao;

	public StudentRegisterService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	/**
	 * 등록되지 않은 학생만 등록할 수 있다.
	 * @param student
	 */
	public void register(Student student) {
		if (verify(student.getsNum())) {
			studentDao.insert(student);
		} else {
			System.out.println("The student has already registered.");
		}
	}

	/**
	 * DB에 이미 등록된 학생인지 판단 
	 * 등록되지 않은 학생 : true / 등록된 학생 : false
	 * @param sNum
	 * @return
	 */
	public boolean verify(String sNum) {
		Student student = studentDao.select(sNum);
		return student == null ? true : false;
	}

}