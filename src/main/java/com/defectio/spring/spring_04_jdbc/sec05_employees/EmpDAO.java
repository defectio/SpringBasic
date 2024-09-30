package com.defectio.spring.spring_04_jdbc.sec05_employees;

import java.util.HashMap;
import java.util.List;

public interface EmpDAO {

	public List<EmpDTO> searchEmpBySal(HashMap<String, Integer> map);

}