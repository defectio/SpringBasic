package com.defectio.spring.spring_02_di.sec01_xml.part09_Contact.dao;

import java.util.HashMap;
import java.util.Map;

import com.defectio.spring.spring_02_di.sec01_xml.part09_Contact.ContactSet;

/**
 * 연락처DB 접속. Service에 의해 호출되어 insert, search 등 기능 수행
 * 
 * @author defec
 *
 */
public class ContactDao {

	private Map<String, ContactSet> contactDB = new HashMap<String, ContactSet>();

	/**
	 * 연락처 정보를 DB에 저장한다.
	 * 
	 * @param contactSet
	 */
	public void insert(ContactSet contactSet) {
		contactDB.put(contactSet.getName(), contactSet);
	}

	/**
	 * 이름으로 연락처를 검색한다.
	 * 
	 * @param name
	 * @return
	 */
	public ContactSet select(String name) {
		return contactDB.get(name);
	}

	/**
	 * DB에 등록된 전체 연락처 정보를 리턴한다.
	 * 
	 * @return
	 */
	public Map<String, ContactSet> getContactDB() {
		return contactDB;
	}

}
