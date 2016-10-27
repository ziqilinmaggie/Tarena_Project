package org.lin.dao;

import java.util.List;

import org.lin.entity.Emp;
import org.lin.entity.Page;

public interface EmpDao {
	public List<Emp> findAll();
	public List<Emp> findPage(Page page);
	public int countTotal();
}
