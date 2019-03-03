package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
}
