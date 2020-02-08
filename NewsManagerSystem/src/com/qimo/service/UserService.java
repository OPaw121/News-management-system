package com.qimo.service;

import java.sql.SQLException;
import java.util.Date;

import javax.security.auth.login.LoginException;

import com.qimo.dao.Userdao;
import com.qimo.domain.User;
import com.qimo.exception.RegisterException;


public class UserService {
	private Userdao dao = new Userdao();

	public void register(User user) throws RegisterException {
		try {
			dao.addUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RegisterException("注冊失败");
		}
	}
	
	public User login(String username, String password) throws LoginException {
		try {
			//根据登录时表单输入的用户名和密码，查找用户
			User user = dao.findUserByUsernameAndPassword(username, password);
			
			if (user != null) {
				return user;
			}
			throw new LoginException("用户名或密码错误");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new LoginException("登录失败");
		}
	}
}
