package com.defectio.spring.spring_02_di;

/**
 * DI에서 사용하는 XML 관련 utils
 */
public class XmlUtils {

	/**
	 * 클래스의 패키지 경로를 돌려준다.
	 * 
	 * @param clazz
	 * @return 패키지 경로
	 */
	public static String getPackageName(Class<?> clazz) {
		String pkgName = null != clazz && null != clazz.getPackage() && null != clazz.getPackage().getName()
				? clazz.getPackage().getName()
				: "";
		String pkgStr = (pkgName != null) ? pkgName.replace('.', '/') : pkgName;
		
		return pkgStr;
	}
	
}
