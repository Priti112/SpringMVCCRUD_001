package com.code.test.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import com.code.test.model.Emp;

public class EmpDaoImpl implements EmpDao {
		
String sql;
JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
	    this.template = template;
    }
	
	
	@Override
	public int insert(Emp e) {
		sql = "insert into employee(name, salary, designation) values(?,?,?)";
		return template.update(sql,e.getName(),e.getSalary(),e.getDesignation());
	}

	@Override
	public int update(Emp e) {
		sql = "update employee set name = ?, salary = ?, designation = ? where id = ?";
		return template.update(sql,e.getName(),e.getSalary(),e.getDesignation(),e.getId());
	}

	@Override
	public int delete(int id) {
		sql = "delete from employee where id = ?";
		return template.update(sql, id);
	}

	@Override
	public List<Emp> listAll() {
		sql = "select * from employee";
		return template.query(sql, new RowMapper<Emp>() {

			@Override
			public Emp mapRow(ResultSet resultSet, int rowNum) throws SQLException {
				Emp e = new Emp();
				e.setId(resultSet.getInt(1));
				e.setName(resultSet.getString(2));
				e.setSalary(Float.parseFloat(resultSet.getString(3)));
				e.setDesignation(resultSet.getString(4));
				return e;
			}
			
		});
	}

	@Override
	public Emp GetById(int id) {
		sql = "select * from employee where id = ?";
		return template.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<Emp>(Emp.class));
	}
	

}
