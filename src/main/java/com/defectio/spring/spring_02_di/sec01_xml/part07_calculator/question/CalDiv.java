package com.defectio.spring.spring_02_di.sec01_xml.part07_calculator.question;

public class CalDiv implements ICalculator {
	
	@Override
	public int doOperation(int firstNum, int secondNum) {
		return secondNum != 0 ? (firstNum / secondNum) : 0;
	
	}
}