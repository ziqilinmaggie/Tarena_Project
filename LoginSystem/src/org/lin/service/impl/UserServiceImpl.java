package org.lin.service.impl;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.lin.dao.UserDao;
import org.lin.entity.User;
import org.lin.service.UserService;
import org.lin.util.Constant;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	@Resource
	private UserDao userDao;
	
	public int checkLogin(String username, String password) {
		
		User user = userDao.findByUserName(username);
		if(user==null){
			return Constant.LOGIN_NAME_ERROR;
		}
		if(user.getPwd().equals(password)){			
			return Constant.LOGIN_OK;
		}else{
			return Constant.LOGIN_PWD_ERROR;
		}
	}

}
