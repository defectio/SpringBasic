package com.defectio.spring.spring_02_di.sec01_xml.part09_Contact.service;

import com.defectio.spring.spring_02_di.sec01_xml.part09_Contact.ContactSet;
import com.defectio.spring.spring_02_di.sec01_xml.part09_Contact.dao.ContactDao;

/**
 * 연락처 정보를 DB에 저장한다.
 * 
 * @author defec
 *
 */
public class ContactRegisterService {

	private ContactDao contactDao;

	/**
	 * 생성자로 ContactDao 의존성 주입 : <constructor-arg>
	 * 
	 * @param contactDao
	 */
	public ContactRegisterService(ContactDao contactDao) {
		System.out.println("contactDao: " + contactDao); // contactDao 출력

		this.contactDao = contactDao;
	}

	/**
	 * 연락처 DB에 등록되지 않은 사람만 등록한다.
	 * 
	 * @param contactSet
	 */
	public void register(ContactSet contactSet) {
		String name = contactSet.getName();
		if (verify(name)) {
			contactDao.insert(contactSet);
		} else {
			System.out.println("The name has already registered.");
		}
	}

	/**
	 * 이름으로 검색하여 연락처DB에 등록되어 있는지 여부를 리턴한다. 등록안되어 있으면: true / 등록되어 있으면: false
	 * 
	 * @param name
	 * @return
	 */
	public boolean verify(String name) {
		ContactSet contactSet = contactDao.select(name);
		return contactSet == null ? true : false;
	}

	// setter
//	public void setContactDao(ContactDao contactDao) {
//		this.contactDao = contactDao;
//	}

}
