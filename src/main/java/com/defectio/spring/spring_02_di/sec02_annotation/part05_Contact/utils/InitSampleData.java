package com.defectio.spring.spring_02_di.sec02_annotation.part05_Contact.utils;

/**
 * 샘플데이터 -> appCtx.xml에서 설정
 * @author defec
 *
 */
public class InitSampleData {

    private String[] names;
    private String[] phoneNumbers;
    
    public String[] getNames() {
        return names;
    }
    public void setNames(String[] names) {
        this.names = names;
    }
    public String[] getPhoneNumbers() {
        return phoneNumbers;
    }
    public void setPhoneNumbers(String[] phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

}
