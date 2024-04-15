package com.defectio.spring.spring_02_di.sec03_javaConfig.part05_EMS.member;

/**
 * 데이터베이스 연결에 필요한 정보
 * @author defec
 *
 */
public class DBConnectionInfo {

	private String url;  // url
	private String userId;  // DB 사용자 id
	private String userPw;  // DB 사용자 pw

	// 각 필드별 getter/setter
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

}