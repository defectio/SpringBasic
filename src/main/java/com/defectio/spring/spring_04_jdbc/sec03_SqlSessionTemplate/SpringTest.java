package com.defectio.spring.spring_04_jdbc.sec03_SqlSessionTemplate;

import java.util.HashMap;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.defectio.spring.spring_02_di.XmlUtils;

public class SpringTest {

	public static void main(String[] args) {
		String pkgName = XmlUtils.getPackageName(SpringTest.class);
		String path = pkgName + "/jdbc.xml";
		
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(path);
		
		MemDAO dao = context.getBean("dao", MemDAO.class);
		
		// 회원정보 등록
//		dao.insertMethod(new MemDTO(5, "이승우", 25, "수원"));
		
		// 회원정보 수정
//		dao.updateMethod(new MemDTO(5, "이승우"));
		
		// 회원정보 삭제
//		dao.deleteMethod(5);
		
		// 회원 정보조회
//		MemDTO dt = dao.select(1);
//		System.out.println("[특정 회원정보 조회]");
//		if(dt != null) {
//			System.out.printf("%d %s %d %s\n", dt.getNum(), dt.getName(), dt.getAge(), dt.getLoc());
//		} else {
//			System.out.println("일치하는 회원 정보가 없습니다.");
//		}
		
		// 전체회원 수 조회
		System.out.println("전체 회원 수 : " +dao.countMethod());
		System.out.println();
		
		// 입력한 회원번호 보다 작은 회원들의 정보 출력
//		System.out.println("[범위로 회원 정보 출력-1]");
//		List<MemDTO> list = dao.searchMethod(4);
//		for(MemDTO mem : list) {
//			System.out.printf("%d %s %d %s\n", mem.getNum(), mem.getName(), mem.getAge(), mem.getLoc());
//		}
//		System.out.println();
		
		// 입력한 숫자 범위로 회원정보 조회
//		System.out.println("[범위로 회원 정보 출력-2]");
//		HashMap<String, Integer> map = new HashMap<String, Integer>();
		//쿼리문을 완성하기에 필요한 파라미터를 key, key에 해당하는 값을 value로 map에 저장한다.
//		map.put("start", 1);
//		map.put("end", 4);
	
//		List<MemDTO> rangeList = dao.searchMethod(map);
//		for(MemDTO mem : rangeList) {
//			System.out.printf("%d %s %d %s\n", mem.getNum(), mem.getName(), mem.getAge(), mem.getLoc());
//		}
//		System.out.println();
		
		// 전체 회원 정보 목록
		List<MemDTO> memList = dao.selectList();
		System.out.println("[전체회원 정보조회]");
		for(MemDTO dto : memList) {
			System.out.printf("%d %s %d %s\n", dto.getNum(), dto.getName(), dto.getAge(), dto.getLoc());
		}

	}

}