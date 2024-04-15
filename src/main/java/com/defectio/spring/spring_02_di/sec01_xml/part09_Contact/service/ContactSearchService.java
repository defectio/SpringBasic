package com.defectio.spring.spring_02_di.sec01_xml.part09_Contact.service;

import com.defectio.spring.spring_02_di.sec01_xml.part09_Contact.ContactSet;
import com.defectio.spring.spring_02_di.sec01_xml.part09_Contact.dao.ContactDao;

/**
 * 특정 연락처(이름으로 검색)의 정보를 검색한다.
 * 
 * @author defec
 *
 */
public class ContactSearchService {

	private ContactDao contactDao;

	/**
	 * 생성자로 ContactDao 의존성 주입 : <constructor-arg>
	 * 
	 * @param contactDao
	 */
	public ContactSearchService(ContactDao contactDao) {
		System.out.println("contactDao: " + contactDao); // contactDao 출력
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

	// setter
//	public void setContactDao(ContactDao contactDao) {
//		this.contactDao = contactDao;
//	}

}
