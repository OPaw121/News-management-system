package com.qimo.dao;

import java.sql.SQLException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.qimo.domain.News;
import com.qimo.domain.User;
import com.qimo.utils.DataSourceUtils;

public class Userdao {
	
		public void addUser(User user) throws SQLException {
			String sql = "insert into user(username,password) values(?,?)";
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			int row = runner.update(sql, user.getUsername(), user.getPassword());
			if (row == 0) {
				throw new RuntimeException();
			}
		}


		public User findUserByUsernameAndPassword(String username, String password) throws SQLException {
			String sql="select * from user where username=? and password=?";
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			return runner.query(sql, new BeanHandler<User>(User.class),username,password);
		}
		
		

}
