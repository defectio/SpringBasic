package com.defectio.spring.spring_02_di.sec03_javaConfig.part05_EMS.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.defectio.spring.spring_02_di.sec03_javaConfig.part05_EMS.member.dao.StudentDao;
import com.defectio.spring.spring_02_di.sec03_javaConfig.part05_EMS.member.service.PrintStudentInformationService;
import com.defectio.spring.spring_02_di.sec03_javaConfig.part05_EMS.member.service.StudentAllSelectService;
import com.defectio.spring.spring_02_di.sec03_javaConfig.part05_EMS.member.service.StudentDeleteService;
import com.defectio.spring.spring_02_di.sec03_javaConfig.part05_EMS.member.service.StudentModifyService;
import com.defectio.spring.spring_02_di.sec03_javaConfig.part05_EMS.member.service.StudentRegisterService;
import com.defectio.spring.spring_02_di.sec03_javaConfig.part05_EMS.member.service.StudentSelectService;
import com.defectio.spring.spring_02_di.sec03_javaConfig.part05_EMS.utils.InitSampleData;

/**
 * 분리된 자바 파일 import : MemberConfig2.java, MemberConfig3.java 파일 import
 * 
 * 스프링 컨테이너가 초기화할 때 각각의 클래스를 import하여 bean 객체를 생성, 주입한다.
 * @author defec
 *
 */
@Configuration
@Import({MemberConfig2.class, MemberConfig3.class})
public class MemberConfigImport {

	@Bean
	public InitSampleData initSampleData() {
		InitSampleData initSampleData = new InitSampleData();
		
		String[] sNums = {"hbs001", "hbs002", "hbs003", "hbs004", "hbs005"};
		initSampleData.setsNums(sNums);
		
		String[] sIds = {"rabbit", "hippo", "raccoon", "elephant", "lion"};
		initSampleData.setsIds(sIds);
		
		String[] sPws = {"p0001", "p0002", "p0003", "p0004", "p0005"};
		initSampleData.setsPws(sPws);
		
		String[] sNames = {"agatha", "barbara", "chris", "doris", "elva"};
		initSampleData.setsNames(sNames);
		
		int[] sAges = {19, 22, 20, 27, 19};
		initSampleData.setsAges(sAges);
		
		char[] sGenders = {'M', 'W', 'W', 'M', 'M'};
		initSampleData.setsGenders(sGenders);
		
		String[] sMajors = {"English", "Korean", "French", "Philosophy", "History"};
		initSampleData.setsMajors(sMajors);
		
		return initSampleData; 
	}
	
	/**
	 * 메서드 이름 = applicationContext.xml 파일에서 설정 했던 bean 객체의 id
	 * return 타입 : applicationContext.xml 파일에서 설정 했던 bean 객체의 타입명
	 *  -> 스프링 컨테이너가 초기화 될 때 StudentDao 객체를 빈 객체로 생성한다.
	 * @return
	 */
	@Bean
	public StudentDao studentDao() {
		return new StudentDao();
	}
	
	// 생성자를 이용해 의존 객체 주입하기
	@Bean
	public StudentRegisterService studentRegisterService() {
		return new StudentRegisterService(studentDao());
	}
	
	@Bean
	public StudentModifyService studentModifyService() {
		return new StudentModifyService(studentDao());
	}
	
	@Bean
	public StudentSelectService studentSelectService() {
		return new StudentSelectService(studentDao());
	}
	
	@Bean
	public StudentAllSelectService studentAllSelectService() {
		return new StudentAllSelectService(studentDao());
	}
	
	@Bean
	public PrintStudentInformationService printStudentInformationService() {
		return new PrintStudentInformationService(studentAllSelectService());
	}
	
	@Bean
	public StudentDeleteService studentDeleteService() {
		return new StudentDeleteService(studentDao());
	}
	
}
