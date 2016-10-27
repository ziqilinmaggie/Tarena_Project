package org.lin.test;

import org.lin.dao.UserDao;
import org.lin.entity.User;
import org.lin.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestService {
	public static void main(String[] args) {
		String conf="applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		UserService service = ac.getBean("userServiceImpl",UserService.class);
		int status = service.checkLogin("king", "1234");
		
			System.out.println(status);
	
	}
}
