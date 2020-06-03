package com.rab3.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rab3.controller.dto.ProfileDTO;

//java8
@Repository
public class ProfileDaoImpl implements ProfileDao {

	@Autowired
	@Qualifier("pkdataSource")
	private DataSource ds;

	@Override
	public String forgetPassword(String email) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
		String sql = "select password  from profiles_tbl where email =?";
		String password = null;
		try {
			password = jdbcTemplate.queryForObject(sql, new Object[] { email }, String.class);
		} catch (DataAccessException e) {
		}
		return password;
	}

	@Override
	public String deleteByusername(String username) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
		String sql = "DELETE from profiles_tbl where username =?";
		jdbcTemplate.update(sql, new Object[] { username });
		return "success";
	}

	@Override
	public ProfileDTO search(String email) {
		System.out.println("email is = " + email);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
		String sql = "select  *  from profiles_tbl where email =" + "'" + email + "'";
		ProfileDTO profileDTO = null;
		try {
			profileDTO = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(ProfileDTO.class));

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(profileDTO);
		return profileDTO;
	}

	@Override
	public String saveProfile(ProfileDTO profileDTO) {
		String sql = "insert into profiles_tbl(username,password,name,email,gender,photo,doe)  values(?,?,?,?,?,?,?);";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
		Timestamp timestamp = new Timestamp(new Date().getTime());
		jdbcTemplate.update(sql,
				new Object[] { profileDTO.getUsername(), profileDTO.getPassword(), profileDTO.getName(),
						profileDTO.getEmail(), profileDTO.getGender(), profileDTO.getPhoto(), timestamp });
		return "success";
	}

	@Override
	public ProfileDTO findById(int aid) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
		String sql = "select  *  from profiles_tbl where aid =" + aid;
		ProfileDTO profileDTO = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(ProfileDTO.class));
		return profileDTO;
	}

	@Override
	public String update(ProfileDTO profileDTO) {
		String sql = "update profiles_tbl set username=? ,name =? ,email =? ,gender =? ,photo= ?  where aid =?";
		Object[] data = { profileDTO.getUsername(), profileDTO.getName(), profileDTO.getEmail(), profileDTO.getGender(),
				profileDTO.getPhoto(), profileDTO.getAid() };
		JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
		jdbcTemplate.update(sql, data);
		return "success";
	}

	@Override
	public List<ProfileDTO> findAll() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
		List<ProfileDTO> profileDTOs = jdbcTemplate.query(
				"select  aid,username,password,name,email,gender,photo,doe,role  from profiles_tbl",
				new BeanPropertyRowMapper<>(ProfileDTO.class));
		return profileDTOs;
	}

	@Override
	public List<ProfileDTO> authLogin(String username, String password) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
		String sql = "select  *  from profiles_tbl where username =? and password = ?";
		List<ProfileDTO> profileDTOs = jdbcTemplate.query(sql, new Object[] { username, password },
				new BeanPropertyRowMapper<ProfileDTO>(ProfileDTO.class));
		return profileDTOs;
	}

	@Override
	public int count() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
		String sql = "SELECT COUNT(*) FROM profiles_tbl";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

}
