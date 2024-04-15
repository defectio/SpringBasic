package com.defectio.spring.spring_02_di.sec03_javaConfig.part05_EMS.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.defectio.spring.spring_02_di.sec03_javaConfig.part05_EMS.member.DBConnectionInfo;
import com.defectio.spring.spring_02_di.sec03_javaConfig.part05_EMS.member.service.EMSInformationService;

/**
 * 자바 파일 분리 : 시스템 정보와 관련된 bean 객체 생성
 * @author defec
 *
 */
@Configuration
public class MemberConfig3 {

	/**
	 * 필드로 의존 객체 자동 주입 
	 * 		-> DBConnectionInfo 타입의 객체를 필요로 하는 메서드에서 사용하기 위해서
	 */
	@Autowired
	DBConnectionInfo dev_DBConnectionInfoDev;

	/**
	 * 필드로 의존 객체 자동 주입 
	 * 		-> DBConnectionInfo 타입의 객체를 필요로 하는 메서드에서 사용하기 위해서
	 */
	@Autowired
	DBConnectionInfo real_DBConnectionInfoDev;
	
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
		
		// MemberConfig2에 선언된 dev_DBConnectionInfoDev(), real_DBConnectionInfoDev() 메서드 호출 불가
		// dbInfos.put("dev", dev_DBConnectionInfoDev());
		// dbInfos.put("real", real_DBConnectionInfoDev());
		
		/**
		 * @Autowired 를 이용해서 DBConnectionInfo 객체 자동주입
		 * 
		 *		(1) DBConnectionInfo 타입 필드 선언 -> @Autowired 어노테이션 선언
		 *		(2) (1)@Autowired에 의해서 자동주입된 DBConnectionInfo 객체를 dbInfos에 put
		 */
		dbInfos.put("dev", dev_DBConnectionInfoDev);
		 dbInfos.put("real", real_DBConnectionInfoDev);
		
		emsInformationService.setDbInfos(dbInfos);
		
		return emsInformationService;
	}
	
}
