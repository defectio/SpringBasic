package com.defectio.spring.spring_04_jdbc.sec05_employees;

import java.util.HashMap;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.defectio.spring.spring_02_di.XmlUtils;

public class EmpTest {

	/**
	 * Employees테이블에서 salary가 5위~10위에 해당하는 employee_id, first_name, salary, hire_date을 출력하시오.
	 *   - 쿼리 먼저 확인 할 것 -> RowNum 활용
	 */
	public static void main(String[] args) {
		
		String pkgName = XmlUtils.getPackageName(EmpTest.class);
		String path = pkgName + "/jdbc.xml";
		
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(path);
		
		EmpDAO empDao = context.getBean("empDao", EmpDAO.class);
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", 5);
		map.put("end", 10);
		
		List<EmpDTO> list = empDao.searchEmpBySal(map);
		
		System.out.println("[월급 5위~10위]");
		for(EmpDTO dto : list) {
			System.out.printf("%s %s %d %s\n", dto.getEmployee_id(), dto.getFirst_name(), dto.getSalary(), dto.getHire_date());
		}
	}

}
