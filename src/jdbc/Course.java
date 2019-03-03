package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Course {

	//新增课程方法
	public String addCourse(String cname,String price,String teacher,String date,String desc1,String desc2) throws SQLException{
				//利用jdbc工具得到connection
				Connection conn = JdbcUtils.getConnection();
				//获取statement
				Statement stat = conn.createStatement();
				//利用statement执行sql语句
				int res = stat.executeUpdate("INSERT INTO course(course_name,price,teacher,date,desc1,desc2) VALUES('"+cname+"','"+price+"','"+teacher+"','"+date+"','"+desc1+"','"+desc2+"') ");
				//System.out.println(res);
				
		return ""+res;
	}
	
}
