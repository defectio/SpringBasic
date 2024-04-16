package com.defectio.spring.spring_02_di.sec01_xml.part06_singleton;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.defectio.spring.spring_02_di.XmlUtils;

public class MainClass {

	public static void main(String[] args) {

		String pkgName = XmlUtils.getPackageName(MainClass.class);
		String path = pkgName + "/applicationContext.xml";
		
		/**
		 * IoC 컨테이너 생성
		 */
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext(path);
		System.out.println("==========컨테이너 생성 완료==========");

		/**
		 * 동일한 DependencyBean을 두 번 호출한다.
		 */
		DependencyBean dependencyBean_01 = ctx.getBean("singletonBean", DependencyBean.class);
		DependencyBean dependencyBean_02 = ctx.getBean("singletonBean", DependencyBean.class);

		/**
		 * Bean 객체의 주소 비교
		 */
		System.out.println("[singleton 테스트]");
		System.out.println("dependencyBean_01 주소 >> "+dependencyBean_01);
		System.out.println("dependencyBean_02 주소 >> "+dependencyBean_02);
		
		/**
		 * Bean 객체가 동등한지 비교
		 * dependencyBean_01, dependencyBean_02는 등일한 객체를 참조하고 있음
		 * -> 싱글턴(singleton) 패턴. 개발자가 특별하게 명시하지 않으면 기본적으로 모든 빈은 싱글턴 범위를 갖는다.
		 * 
		 */
		if (dependencyBean_01.equals(dependencyBean_02)) {
			System.out.println("dependencyBean_01 == dependencyBean_02");
		} else {
			System.out.println("dependencyBean_01 != dependencyBean_02");
		}
		System.out.println();
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		/**
		 * 동일한 DependencyBean을 두 번 호출한다.
		 */
		DependencyBean dependencyBean_03 = ctx.getBean("noSingletonBean", DependencyBean.class);
		DependencyBean dependencyBean_04 = ctx.getBean("noSingletonBean", DependencyBean.class);

		/**
		 * Bean 객체의 주소 비교
		 */
		System.out.println("[noSingleton 테스트]");
		System.out.println("dependencyBean_03 >> "+dependencyBean_03);
		System.out.println("dependencyBean_04 >> "+dependencyBean_04);
		
		/**
		 * Bean 객체가 동등한지 비교
		 * dependencyBean_03, dependencyBean_04는 다른 객체를 참조하고 있음
		 * scope="prototype" -> 싱글턴 범위와 반대되는 개념. Bean 객체를 singleton으로 생성하지 않음.
		 */
		if (dependencyBean_03.equals(dependencyBean_04)) {
			System.out.println("dependencyBean_03 == dependencyBean_04");

		} else {
			System.out.println("dependencyBean_03 != dependencyBean_04");

		}

	}

}