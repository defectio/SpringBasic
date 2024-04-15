package com.defectio.spring.spring_02_di.sec03_javaConfig.part05_EMS.member.service;

import java.util.Map;

import com.defectio.spring.spring_02_di.sec03_javaConfig.part05_EMS.member.Student;
import com.defectio.spring.spring_02_di.sec03_javaConfig.part05_EMS.member.dao.StudentDao;

/**
 * DB에 등록된 학생 전체를 검색한다.
 * @author defec
 *
 */
public class StudentAllSelectService {

	private StudentDao studentDao;

	public StudentAllSelectService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	/**
	 * DB에 등록된 학생 전체를 리턴한다.
	 * @return
	 */
	public Map<String, Student> allSelect() {
		return studentDao.getStudentDB();
	}

}