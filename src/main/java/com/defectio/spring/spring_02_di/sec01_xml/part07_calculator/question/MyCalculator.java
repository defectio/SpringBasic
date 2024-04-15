package com.defectio.spring.spring_02_di.sec01_xml.part07_calculator.question;

public class MyCalculator {
    
	public void calculate(int fNum, int sNum, ICalculator calculator) {
		int value = calculator.doOperation(fNum, sNum); // 연산 실행
		System.out.println("result : " + value);
    }

}