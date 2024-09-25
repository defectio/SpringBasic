package com.defectio.spring.spring_04_jdbc.sec01_JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MemDaoImp implements MemDAO{
	
	private JdbcTemplate jdbcTemplate;
	
	public MemDaoImp() {}

	// setter를 통해서 의존성 주입
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	/**
	 * [JdbcTemplate 에서 제공하는 쿼리메소드] 
	 * 	- queryXXX() : DB에서 select문 조회결과를 가져올 때
	 * 	- update() : DB 테이블에 insert/update/delete문 실행할 때 
	 * 
	 * 1. query(psc, rowMapper) : 쿼리문의 결과값을 list로 반환함. & RowMapper<T> 재정의 해서 사용함 
	 *     커서이동 없음(rs.next() 사용 안한다)  -> 일일이 결과값을 List 객체에 담을 필요없음
	 *     "query(sql, new RowMapper<T>() {});  -> List로 반환"
	 *     
	 * 2. queryForObject(sql, rowMapper) : 설정한 타입으로 리턴
	 *     queryForObject(sql, new RowMapper<T> () {});  -> 제네릭에 설정한 타입으로 반환
	 *     
	 * 3. update(sql, args) : 쿼리문과 object타입으로 업데이트
	 * 			- update, delete, insert 모두 update() 메소드로 처리한다. 즉, sql문에 따라 달라짐.
	 * 
	 */

	/**
	 * 전체 회원정보 목록을 리턴한다.
	 */
	@Override
	public List<MemDTO> selectList() {
		String sql = "SELECT * FROM hr.mem ORDER BY num";
		
		/**
		 * [query() 메소드]
		 * ㅇ RowMapper 익명 객체 구현 -> override 해야할 메소드(mapRow) 1개 있음
		 *  - RowMapper<T> 제네릭 타입에 설정한 타입으로 override 할 mapRow 메소드의 리턴타입이 된다.
		 *  - mybatis 연동하면 쓸일 없음. 한번 알아두고 넘어가 
		 */
		List<MemDTO> list = jdbcTemplate.query(sql, new RowMapper<MemDTO>() {
			
			/**
			 * - rs : 쿼리문(select) 실행결과가 ResultSet 객체에 담긴다.
			 * - arg1 : 행번호(이건 필요없음) 
			 */
			@Override
			public MemDTO mapRow(ResultSet rs, int arg1) throws SQLException {
				MemDTO dto = new MemDTO();  
				
				// DB 조회 결과의 컬럼값을 가져와 dto 객체에 담는다. 
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				dto.setLoc(rs.getString("loc"));
				
				return dto;
			}			
		});
		
		return list;
	}

	/**
	 * 회원정보를 등록한다.
	 */
	@Override
	public void insertMethod(MemDTO dto) {
		String sql = "INSERT INTO hr.mem VALUES(?, ?, ?, ?)";
		Object[] args = new Object[] {dto.getNum(), dto.getName(), dto.getAge(), dto.getLoc()};
		
		jdbcTemplate.update(sql, args);
	}

	/**
	 * 회원정보를 수정한다.
	 */
	@Override
	public void updateMethod(MemDTO dto) {
		String sql = "UPDATE hr.mem SET name= ? WHERE num= ?";
		Object[] args = new Object[] {dto.getName(), dto.getNum()};
		
		jdbcTemplate.update(sql, args);	
	}

	/**
	 * 회원정보를 삭제한다.
	 */
	@Override
	public void deleteMethod(int num) {
		String sql = "DELETE FROM hr.mem WHERE num= ?";
		Object[] args = new Object[] {num};
		
		jdbcTemplate.update(sql, args);
	}

	/**
	 * 특정 회원정보 목록을 리턴한다.
	 *  - query() 메소드 : RowMapper 제네릭으로 설정한 타입의 list로 리턴
	 *  - queryForObject() 메소드 : RowMapper 제네릭으로 설정한 타입으로 리턴
	 */
	@Override
	public MemDTO select(int num) {
		String sql = "SELECT * FROM hr.mem WHERE num = ?";
		Object[] args = new Object[] {num};
		
		/**
		 * [queryForObject() 메소드]
		 * ㅇ RowMapper 익명 객체 구현 -> override 해야할 메소드(mapRow) 1개 있음
		 *  - RomMapper<T> 에서 지정한 타입으로 리턴하는 메소드
		 */
		return jdbcTemplate.queryForObject(sql, args, new RowMapper<MemDTO>() {
			@Override
			public MemDTO mapRow(ResultSet rs, int arg1) throws SQLException {
				MemDTO dto = new MemDTO();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				dto.setLoc(rs.getString("loc"));
				
				return dto;
			}			
		});
		
	}

	/**
	 * 등록된 회원 수를 리턴한다.
	 */
	@Override
	public int countMethod() {
		String sql = "SELECT count(*) FROM hr.mem";
		return jdbcTemplate.queryForObject(sql, new RowMapper<Integer>() {
			@Override
			public Integer mapRow(ResultSet rs, int arg1) throws SQLException {
				//return rs.getInt("count(*)"); 이렇게 가져올 수도 있지만 컬럼에 식처리 되어 있으면 index(알리아스)로 가져온다.
				return rs.getInt(1);
			}
		});
	}
	
}