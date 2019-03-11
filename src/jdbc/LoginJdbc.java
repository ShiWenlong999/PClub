package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import pojo.User;

public class LoginJdbc {

	//登陆方法
	public String login(String account,String password) throws SQLException {
		//利用jdbc工具得到connection
		Connection conn = JdbcUtils.getConnection();
		//获取statement
		Statement stat = conn.createStatement();
		//利用statement执行sql语句
		ResultSet rest = stat.executeQuery("select count(*) from user where phone='"+account+"' and password='"+password+"'");
		int a=0;
		while (rest.next()) {
			a = rest.getInt(1);
		}
		return a+"";
	}
	
	//根据账号查询用户信息
	public User getUserBya(String account) throws SQLException {
		//利用jdbc工具得到connection
				Connection conn = JdbcUtils.getConnection();
				//获取statement
				Statement stat = conn.createStatement();
				//利用statement执行sql语句
				ResultSet rs = stat.executeQuery("select * from user where phone='"+account+"'");
				//创建User对象
				User user = new User();
				while(rs.next()) {
					user.setId(Integer.parseInt(rs.getString("id"))); //将数据库查出的id字段的值赋给user对象的id属性
					user.setName(rs.getString("name"));
					//user.setAge(Integer.parseInt(rs.getString("age")));
					user.setPhone(rs.getString("phone"));
					user.setPassword(rs.getString("password"));
					//user.setSex(Integer.parseInt(rs.getString("sex")));
				}
		return user;
	}
	
}
