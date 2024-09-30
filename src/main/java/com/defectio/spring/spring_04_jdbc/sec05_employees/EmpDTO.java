package com.defectio.spring.spring_04_jdbc.sec05_employees;

import java.sql.Date;

public class EmpDTO {
	private String employee_id;  // 사번
	private String first_name;   // 이름
	private int salary;  	     // 봉급
	private Date hire_date; 	 // 입사일자
	
	public EmpDTO() {}
	
	public String getEmployee_id() {
		return employee_id;
	}
	
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	
	public String getFirst_name() {
		return first_name;
	}
	
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public Date getHire_date() {
		return hire_date;
	}
	
	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}
	
}