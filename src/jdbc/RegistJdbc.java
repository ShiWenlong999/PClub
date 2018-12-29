package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RegistJdbc {
	
	public String regist(String username,String password) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		Statement stat = conn.createStatement(); //statement接口作用是执行SQL语句，可以获取查询结果集。
		//boolean execute = stat.execute("insert into user (name,pass) values('"+username+"','"+password+"')");
		int res = stat.executeUpdate("insert into user (name,pass) values('"+username+"','"+password+"')");
		
		return res+"";
	}
	public String selUsername(String username) throws SQLException{
		Connection conn = JdbcUtils.getConnection();
		Statement stat = conn.createStatement(); //statement接口作用是执行SQL语句，可以获取查询结果集。
		ResultSet rest = stat.executeQuery("select count(*) from user where name='"+username+"'");
		int a=0;
		while (rest.next()) {
			a = rest.getInt(1);
			
		}
		return a+"";
	}
	
}
