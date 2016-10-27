package org.lin.test;

import org.lin.dao.UserDao;
import org.lin.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserDao {
	public static void main(String[] args) {
		String conf="applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		UserDao dao = ac.getBean("userDaoImpl",UserDao.class);
		User user = dao.findByUserName("小涵涵");
		if(user==null){
			System.out.println("not exist");
		}else{
			System.out.println("finded");
		}
	}
}
