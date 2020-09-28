package com.code.test.dao;

import java.util.List;


import com.code.test.model.Emp;

public interface EmpDao {
	int insert(Emp e);
	int update(Emp e);
	int delete(int id);
	List<Emp> listAll();
	Emp GetById(int id);

}
