package com.defectio.spring.spring_04_jdbc.sec04_SqlSessionDaoSupport;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
* [Template 클래스]
* 	1. 개발자가 중복된 코드를 입력해야 하는 작업을 줄일 수 있도록 돕고 있다.
* 	2. JDBC 뿐만 아니라 mybatis, JMS와 같은 다양한 기술에 대해 템플릿을 제공한다.
* 	3. 예를들어 JDBC인 경우 JdbcTemplate 클래스를 제공하고 있으며, JdbcTemplate클래스를 사용함으로써,
* 		try~catch~finally 및 커넥션 관리를 위한 중복된 코드를 줄이거나 없앨 수 있다.
* 
* 								  [Java JDBC]          		[Spring JDBC]                		[MyBatis]
* 			select               executeQuery()        query(), queryForObject()         selectList(), selectOne()
* 	insert, update, delete       executeUpdate()      			update()         		insert(), update(), delete()
*/

/**
 * SqlSessionDaoSupport 상속
 *  - sqlSession 선언이 없고, getSqlSession() 메소드로 mapper 접근
 *  - 즉, SqlSessionDaoSupport의 getSqlSession() 메소드로 SqlSession 객체 획득
 * @author USER
 *
 */
public class MemDaoImp extends SqlSessionDaoSupport implements MemDAO {
	
	public MemDaoImp() {
	
	}

	/**
	 * 전체 회원정보 목록을 리턴한다.
	 *  - selectList() 메소드 : SqlSessionTemplate에서 제공하는 메소드(리턴타입:list) -> 반환하는 행이 여러개 일때 사용
	 *  - selectOne() 메소드 : SqlSessionTemplate에서 제공하는 메소드 -> 반환하는 행이 없거나 1개일때 사용 
	 */
	@Override
	public List<MemDTO> selectList() {
		return getSqlSession().selectList("mem.all");
	}

	/**
	 * 회원정보를 등록한다.
	 *  - "mem.insert" : 쿼리문을 실행하기 위해서 memMapper.xml의 "namespace명.id명" 값으로 접근(쿼리문 선택)
	 *  - dto : 메소드 실행을 위한 parameter(memMapper.xml의 parameterType 으로 설정되야함) -> parameter을 mapper로 전달해서 쿼리문 실행한다.
	 */
	@Override
	public void insertMethod(MemDTO dto) {
		getSqlSession().insert("mem.insert", dto);
	}

	/**
	 * 회원정보를 수정한다.
	 *  - update() 메소드 : SqlSessionTemplate 에서 제공하는 메소드 -> mapper에서 사용하는 쿼리문이 update문일 때 사용
	 */
	@Override
	public void updateMethod(MemDTO dto) {
		getSqlSession().update("mem.update", dto);
	}

	/**
	 * 회원정보를 삭제한다.
	 *  - delete() 메소드 : SqlSessionTemplate 에서 제공하는 메소드 -> mapper에서 사용하는 쿼리문이 delete문일 때 사용
	 */
	@Override
	public void deleteMethod(int num) {
		getSqlSession().delete("mem.delete", num);
	}

	/**
	 * 특정 회원정보 목록을 리턴한다.
	 *  - selectOne() : 리턴값이 1개이거나 없을 때 사용
	 */

	@Override
	public MemDTO select(int num) {
		return getSqlSession().selectOne("mem.one", num);
	}

	/**
	 * 등록된 회원 수를 리턴한다.
	 */
	@Override
	public int countMethod() {
		return getSqlSession().selectOne("mem.count");
	}

	/**
	 * 입력한 숫자 보다 번호가 작은 회원정보 출력 
	 */
	@Override
	public List<MemDTO> searchMethod(int num) {
		return getSqlSession().selectList("mem.search", num);
	}

	/**
	 * 입력한 숫자 범위로 회원정보 출력
	 *  - query문에 들어가는 값이 2개 여서 DTO 불가능
	 */
	@Override
	public List<MemDTO> searchMethod(HashMap<String, Integer> map) {
		return getSqlSession().selectList("mem.range", map);
	}
		
}