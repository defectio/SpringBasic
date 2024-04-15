package com.defectio.spring.spring_02_di.sec01_xml.part07_calculator.answer;

public class CalMul implements ICalculator {
	
	@Override
	public int doOperation(int firstNum, int secondNum) {
		return firstNum * secondNum;
	}

}