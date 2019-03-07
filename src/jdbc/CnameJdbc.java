package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CnameJdbc {

	public String addCname(String uname,String cname,String sex,String age,String phone,String date) throws SQLException {
		//利用jdbc工具得到connection
		Connection conn = JdbcUtils.getConnection();
		//获取statement
		Statement stat = conn.createStatement();
		//利用statement执行sql语句 ，将报名信息插入到报名表
		int res = stat.executeUpdate("INSERT INTO user_course(username,coursename,sex,age,phone,regdate) VALUES('"+uname+"','"+cname+"','"+sex+"','"+age+"','"+phone+"','"+date+"')");
		return ""+res;
	}
}
