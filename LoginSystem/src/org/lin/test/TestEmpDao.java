package org.lin.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.lin.entity.Emp;
import org.lin.entity.Page;

public class TestEmpDao {
	//@Test
//	public void findAll(){
//		SqlSession session = SqlSessionUtil.getSession();
//		List<Emp> list = session.selectList("findAll");
//		for(Emp e:list){
//			System.out.println(e);
//		}
//		session.close();
//	}
//	@Test
//	public void findPage(){
//		SqlSession session = SqlSessionUtil.getSession();
//		Page page = new Page();
//		page.setPage(1);
//		page.setPageSize(3);
//		List<Emp> list = session.selectList("findPage",page);
//		int total = session.selectOne("countTotal");
//		
//		for(Emp e:list){
//			System.out.println(e);
//		}
//		System.out.println(total);
//		session.close();
//	}
}
