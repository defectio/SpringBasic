package com.defectio.spring.spring_02_di.sec02_annotation.part05_Contact.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;

import com.defectio.spring.spring_02_di.sec02_annotation.part05_Contact.ContactSet;
import com.defectio.spring.spring_02_di.sec02_annotation.part05_Contact.dao.ContactDao;

/**
 * 특정 연락처(이름으로 검색)의 정보를 검색한다.
 * 
 * @author defec
 *
 */
public class ContactSearchService {

	/**
	 * 필드에 @Qualifier 선언 방법
	 */
//	@Resource
//	@Qualifier("userDao")
	private ContactDao contactDao;
	
//	@Resource
//	private @Qualifier("userDao") ContactDao contactDao;

	public ContactSearchService() {}
	
	/**
	 * 생성자에 @Resource 사용 불가
	 * @param contactDao
	 */
//	@Resource // -> The annotation @Resource is disallowed for this location
	public ContactSearchService(ContactDao contactDao) {
		this.contactDao = contactDao;
	}

	/**
	 * setter @Qualifier 선언 방법
	 * @param contactDao
	 */
//	[방법 1]
//	@Resource
//	@Qualifier("userDao")
//	public void setContactDao(ContactDao contactDao) {
//		this.contactDao = contactDao;
//	}
	
//	[방법 2]
	@Resource
	public void setContactDao(@Qualifier("userDao") ContactDao contactDao) {
		this.contactDao = contactDao;
	}
	
	/**
	 * 연락처 DB에 등록되어 있는만 검색한다.
	 * 
	 * @param contactSet
	 */
	public ContactSet searchContact(String name) {
		if (verify(name)) {
			return contactDao.select(name);
		} else {
			System.out.println("Contact information is available.");
		}

		return null;
	}

	/**
	 * 이름으로 검색하여 연락처DB에 등록되어 있는지 여부를 리턴한다. 등록되어 있으면: true / 등록안되어 있으면: false
	 * 
	 * @param name
	 * @return
	 */
	public boolean verify(String name) {
		ContactSet contactSet = contactDao.select(name);
		return contactSet != null ? true : false;
	}

}
