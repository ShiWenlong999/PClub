package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class RegistJdbc {
	
	public String regist(String username,String password) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		Statement stat = conn.createStatement(); //statement接口作用是执行SQL语句，可以获取查询结果集。
		boolean execute = stat.execute("insert into user (name,pass) values('"+username+"','"+password+"')");
		System.out.println(execute);
		String res ="";
		if(execute) {
			res="1";
		}else {
			res="0";
		}
		return res;
	}
}
