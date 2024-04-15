package com.defectio.spring.spring_02_di.sec03_javaConfig.part05_EMS.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.defectio.spring.spring_02_di.sec03_javaConfig.part05_EMS.member.DBConnectionInfo;

/**
 * 자바 파일 분리 : 데이터베이스와 관련한 bean 객체 생성
 * @author defec
 *
 */
@Configuration
public class MemberConfig2 {

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
		
}
