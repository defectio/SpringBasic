package com.defectio.spring.spring_04_jdbc.sec01_template;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	public static void main(String[] args) {
		String path ="com/defectio/spring/spring_04_jdbc/sec01_template/jdbc.xml";
		
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(path);
		
		MemDAO dao = context.getBean("dao", MemDAO.class);
		
		// 회원정보 등록
//		dao.insertMethod(new MemDTO(3, "이강인", 25, "파리"));
//		dao.insertMethod(new MemDTO(4, "김민재", 30, "뮌헨"));
		
		// 회원정보 수정
//		dao.updateMethod(new MemDTO(1, "손흥민"));
		
		/* 회원정보 삭제(회원의 num으로 회원정보 삭제) */
//		dao.deleteMethod(2);
		
		// 회원 정보조회
		MemDTO dt = dao.select(3);
		System.out.println("[특정 회원정보 조회]");
		System.out.printf("%d %s %d %s\n", dt.getNum(), dt.getName(), dt.getAge(), dt.getLoc());
		System.out.println();
		
		/* 전체회원 수 조회 */
		System.out.println("전체 회원 수 : " +dao.countMethod());
		System.out.println();
		
		System.out.println("[전체회원 정보조회]");
		List<MemDTO> list = dao.selectList();
		if (list.size() < 0) {
			System.out.println("출력할 회원이 없습니다.");
		} else {
			for(MemDTO dto : list) {
				System.out.printf("%d %s %d %s\n", dto.getNum(), dto.getName(), dto.getAge(), dto.getLoc());
			}
		}
		
	}  //end main

}  //end class
