package com.defectio.spring.spring_04_jdbc.sec02_JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * [JdbcDaoSupport] 클래스 상속
 * JdbcTemplate을 의존성 주입받는 것이 아닌, JdbcDaoSupport에서 getJdbcTemplate()를 통해 사용함.
 */
public class MemDaoImp extends JdbcDaoSupport implements MemDAO{
	
	public MemDaoImp() {}
	
	/**
	 * 전체 회원정보 목록을 리턴한다.
	 */
	@Override 
	public List<MemDTO> selectList() {
		String sql = "select * from mem order by num";
		
		List<MemDTO> list = getJdbcTemplate().query(sql, new RowMapper<MemDTO>() {
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
		
		return list;
	}

	/**
	 * 회원정보를 등록한다.
	 */
	@Override
	public void insertMethod(MemDTO dto) {
		String sql = "INSERT INTO hr.mem VALUES(?, ?, ?, ?)";
		Object[] args = new Object[] {dto.getNum(), dto.getName(), dto.getAge(), dto.getLoc()};
		
		getJdbcTemplate().update(sql, args);
	}

	/**
	 * 회원정보를 수정한다.
	 */
	@Override
	public void updateMethod(MemDTO dto) {
		String sql = "UPDATE hr.mem SET name = ? WHERE num = ?";
		Object[] args = new Object[] {dto.getName(), dto.getNum()};
		
		getJdbcTemplate().update(sql, args);	
	}

	/**
	 * 회원정보를 수정한다.
	 */
	@Override
	public void deleteMethod(int num) {
		String sql = "DELETE FROM hr.mem WHERE num = ?";
		Object[] args = new Object[] {num};
		
		getJdbcTemplate().update(sql, args);
	}

	/**
	 * 특정 회원정보 목록을 리턴한다.
	 */
	@Override
	public MemDTO select(int num) {
		String sql = "SELECT * FROM hr.mem WHERE num=?";
		Object[] args = new Object[] {num};
		
		return  getJdbcTemplate().queryForObject(sql, args, new RowMapper<MemDTO>() {
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
		return  getJdbcTemplate().queryForObject(sql, new RowMapper<Integer>() {
			@Override
			public Integer mapRow(ResultSet rs, int arg1) throws SQLException {
				//return rs.getInt("count(*)"); 이렇게 가져올 수도 있지만 컬럼에 식처리 되어 있으면 index(알리아스)로 가져온다.
				return rs.getInt(1);
			}
		});
	}
	
}