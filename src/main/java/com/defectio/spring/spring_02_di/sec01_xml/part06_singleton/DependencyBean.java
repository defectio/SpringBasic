package com.defectio.spring.spring_02_di.sec01_xml.part06_singleton;

public class DependencyBean {
    
    InjectionBean injectionBean;
    
    /**
     * 객체가 생성될 때 생성자를 통해서 InjectionBean를 주입받는다.
     * @param injectionBean
     */
    public DependencyBean(InjectionBean injectionBean) {
        this.injectionBean = injectionBean;
    }
}