package com.defectio.spring.spring_02_di.sec03_javaConfig.part05_EMS.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.defectio.spring.spring_02_di.sec03_javaConfig.part05_EMS.member.DBConnectionInfo;
import com.defectio.spring.spring_02_di.sec03_javaConfig.part05_EMS.member.dao.StudentDao;
import com.defectio.spring.spring_02_di.sec03_javaConfig.part05_EMS.member.service.EMSInformationService;
import com.defectio.spring.spring_02_di.sec03_javaConfig.part05_EMS.member.service.PrintStudentInformationService;
import com.defectio.spring.spring_02_di.sec03_javaConfig.part05_EMS.member.service.StudentAllSelectService;
import com.defectio.spring.spring_02_di.sec03_javaConfig.part05_EMS.member.service.StudentDeleteService;
import com.defectio.spring.spring_02_di.sec03_javaConfig.part05_EMS.member.service.StudentModifyService;
import com.defectio.spring.spring_02_di.sec03_javaConfig.part05_EMS.member.service.StudentRegisterService;
import com.defectio.spring.spring_02_di.sec03_javaConfig.part05_EMS.member.service.StudentSelectService;
import com.defectio.spring.spring_02_di.sec03_javaConfig.part05_EMS.utils.InitSampleData;

@Configuration
public class MemberConfig {

	/**
	 * 메서드 이름 = applicationContext.xml 파일에서 설정 했던 bean 객체의 id
	 * return 타입 : applicationContext.xml 파일에서 설정 했던 bean 객체의 타입명
	 *  -> 스프링 컨테이너가 초기화 될 때 StudentDao 객체를 Bean 객체로 생성한다.
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
	
	// setter 메서드를 이용해 의존 객체 주입하기
	@Bean
	public DBConnectionInfo dev_DBConnectionInfoDev() {
		DBConnectionInfo dbConnectionInfo = new DBConnectionInfo();
		dbConnectionInfo.setUrl("000.000.000.000");
		dbConnectionInfo.setUserId("admin");
		dbConnectionInfo.setUserPw("0000");
		
		return dbConnectionInfo;
	}
	
	@Bean
	public DBConnectionInfo real_DBConnectionInfoDev() {
		DBConnectionInfo dbConnectionInfo = new DBConnectionInfo();
		dbConnectionInfo.setUrl("111.111.111.111");
		dbConnectionInfo.setUserId("master");
		dbConnectionInfo.setUserPw("1111");
		
		return dbConnectionInfo;
	}
	
	@Bean
	public EMSInformationService eMSInformationService() {
		
		EMSInformationService emsInformationService = 
				new EMSInformationService();
		emsInformationService.setInfo("Education Management System program was developed in 2022.");
		emsInformationService.setCopyRight("COPYRIGHT(C) 2022 EMS CO., LTD. ALL RIGHT RESERVED. CONTACT MASTER FOR MORE INFORMATION.");
		emsInformationService.setVer("The version is 1.0");
		emsInformationService.setsYear(2022);
		emsInformationService.setsMonth(3);
		emsInformationService.setsDay(1);
		emsInformationService.seteYear(2022);
		emsInformationService.seteMonth(4);
		emsInformationService.seteDay(30);
		
		List<String> developers = new ArrayList<String>();
		developers.add("Cheney.");
		developers.add("Eloy.");
		developers.add("Jasper.");
		developers.add("Dillon.");
		developers.add("Kian.");
		emsInformationService.setDevelopers(developers);
		
		Map<String, String> administrators = new HashMap<String, String>();
		administrators.put("Cheney", "cheney@springPjt.org");
		administrators.put("Jasper", "jasper@springPjt.org");
		emsInformationService.setAdministrators(administrators);
		
		Map<String, DBConnectionInfo> dbInfos = new HashMap<String, DBConnectionInfo>();
		dbInfos.put("dev", dev_DBConnectionInfoDev());
		dbInfos.put("real", real_DBConnectionInfoDev());
		emsInformationService.setDbInfos(dbInfos);
		
		return emsInformationService;
	}
	
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
	
}
