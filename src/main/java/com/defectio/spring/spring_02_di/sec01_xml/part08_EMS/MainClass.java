package com.defectio.spring.spring_02_di.sec01_xml.part08_EMS;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.defectio.spring.spring_02_di.XmlUtils;
import com.defectio.spring.spring_02_di.sec01_xml.part08_EMS.member.Student;
import com.defectio.spring.spring_02_di.sec01_xml.part08_EMS.member.service.EMSInformationService;
import com.defectio.spring.spring_02_di.sec01_xml.part08_EMS.member.service.PrintStudentInformationService;
import com.defectio.spring.spring_02_di.sec01_xml.part08_EMS.member.service.StudentDeleteService;
import com.defectio.spring.spring_02_di.sec01_xml.part08_EMS.member.service.StudentModifyService;
import com.defectio.spring.spring_02_di.sec01_xml.part08_EMS.member.service.StudentRegisterService;
import com.defectio.spring.spring_02_di.sec01_xml.part08_EMS.member.service.StudentSelectService;
import com.defectio.spring.spring_02_di.sec01_xml.part08_EMS.utils.InitSampleData;

public class MainClass {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		/**
		 * IoC 컨테이너 생성
		 */
		String pkgName = XmlUtils.getPackageName(MainClass.class);
//		String path = pkgName + "/applicationContext.xml";
		
//		ApplicationContext ctx = new ClassPathXmlApplicationContext(path);

		/**
		 * [방식 1]. 파일을 분리해서 관리
		 * applicationContext.xml 파일 분리 -> appCtx1.xml, appCtx2.xml, appCtx3.xml
		 */
//		String path1 = pkgName + "/appCtx1.xml";
//		String path2 = pkgName + "/appCtx2.xml";
//		String path3 = pkgName + "/appCtx3.xml";
//		ApplicationContext ctx = new ClassPathXmlApplicationContext(path1, path2, path3);

        /**
         * appCtx1.xml, appCtx2.xml, appCtx3.xml을 가독성 좋게 String[] 배열로 변경
         */
//        String[] appCtxs = {
//        		pkgName + "/appCtx1.xml", 
//        		pkgName + "/appCtx2.xml", 
//        		pkgName + "/appCtx3.xml"}; 
//        ApplicationContext ctx = new ClassPathXmlApplicationContext(appCtxs);

		/**
		 * [방식 2]. xml 파일 안에서 imort 사용
		 * import 방식으로 변경
		 */
		String importPath = pkgName + "/appCtxImport.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(importPath);

		// 샘플 데이터
		InitSampleData initSampleData = ctx.getBean("initSampleData", InitSampleData.class);
		String[] sNums = initSampleData.getsNums();
		String[] sIds = initSampleData.getsIds();
		String[] sPws = initSampleData.getsPws();
		String[] sNames = initSampleData.getsNames();
		int[] sAges = initSampleData.getsAges();
		char[] sGenders = initSampleData.getsGenders();
		String[] sMajors = initSampleData.getsMajors();

		/**
		 * 데이터베이스에 샘플 데이터 등록
		 */
		StudentRegisterService registerService = ctx.getBean("studentRegisterService", StudentRegisterService.class);
		for (int i = 0; i < sNums.length; i++) {
			registerService
					.register(new Student(sNums[i], sIds[i], sPws[i], sNames[i], sAges[i], sGenders[i], sMajors[i]));
		}
		// 학생 리스트 출력
		PrintStudentInformationService printStudentInformatinService = ctx.getBean("printStudentInformationService",
				PrintStudentInformationService.class);
		printStudentInformatinService.printStudentsInfo(); // 학생 리스트

		/**
		 * 학생 등록
		 */
		registerService = ctx.getBean("studentRegisterService", StudentRegisterService.class);
		registerService.register(new Student("hbs006", "deer", "p0006", "melissa", 26, 'w', "Music"));

		printStudentInformatinService.printStudentsInfo(); // 학생 리스트

		/**
		 * hbs006 학생 select -> 출력
		 */
		StudentSelectService selectService = ctx.getBean("studentSelectService", StudentSelectService.class);
		Student selectedstudent = selectService.select("hbs006");

		System.out.println("STUDENT START ------------------");
		System.out.print("sNum:" + selectedstudent.getsNum() + "\t");
		System.out.print("|sId:" + selectedstudent.getsId() + "\t");
		System.out.print("|sPw:" + selectedstudent.getsPw() + "\t");
		System.out.print("|sName:" + selectedstudent.getsName() + "\t");
		System.out.print("|sAge:" + selectedstudent.getsAge() + "\t");
		System.out.print("|sGender:" + selectedstudent.getsGender() + "\t");
		System.out.println("|sMajor:" + selectedstudent.getsMajor());
		System.out.println("END ----------------------------");

		/**
		 * hbs006 학생 정보 수정
		 */
		StudentModifyService modifyService = ctx.getBean("studentModifyService", StudentModifyService.class);
		modifyService.modify(new Student("hbs006", "pig", "p0066", "melissa", 27, 'w', "Computer"));

		printStudentInformatinService.printStudentsInfo(); // 학생 리스트

		/**
		 *  hbs005 학생 삭제
		 */
		StudentDeleteService deleteService = ctx.getBean("studentDeleteService", StudentDeleteService.class);
		deleteService.delete("hbs005");

		printStudentInformatinService.printStudentsInfo(); // 학생 리스트

		// 시스템 정보
		EMSInformationService emsInformationService = ctx.getBean("eMSInformationService", EMSInformationService.class);
		emsInformationService.printEMSInformation();

	}
}