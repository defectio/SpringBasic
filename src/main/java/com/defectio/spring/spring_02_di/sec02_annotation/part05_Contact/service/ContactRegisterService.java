package com.defectio.spring.spring_02_di.sec02_annotation.part05_Contact.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.defectio.spring.spring_02_di.sec02_annotation.part05_Contact.ContactSet;
import com.defectio.spring.spring_02_di.sec02_annotation.part05_Contact.dao.ContactDao;

/**
 * 연락처 정보를 DB에 저장한다.
 * 
 * @author defec
 *
 */
public class ContactRegisterService {

	/**
	 * 필드에 @Qualifier 선언 방법
	 */
//	@Autowired
//	@Qualifier("userDao")
	private ContactDao contactDao;
	
//	@Autowired
//	private @Qualifier("userDao") ContactDao contactDao;
	
	public ContactRegisterService() {}
	
	/**
	 * 생성자에 @Qualifier 선언 방법 -> 매개변수에만 선언 가능
	 * @param contactDao
	 */
	@Autowired
//	@Qualifier("userDao") // The annotation @Qualifier is disallowed for this location
	public ContactRegisterService(@Qualifier("userDao") ContactDao contactDao) {
		this.contactDao = contactDao;
	}

	
	/**
	 * setter에 @Qualifier 선언 방법
	 * @param contactDao
	 */
//	[방법 1]
//	@Autowired
//	@Qualifier("userDao")
	public void setContactDao(ContactDao contactDao) {
        this.contactDao = contactDao;
    }
	
//	[방법 2]
//	@Autowired
//	public void setContactDao(@Qualifier("userDao") ContactDao contactDao) {
//        this.contactDao = contactDao;
//    }

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
	
}
