package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import pojo.CourseP;

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
	
	//查询所有课程
	public static  List<CourseP> selCourse(String state) throws SQLException{
		//利用jdbc工具得到connection
		Connection conn = JdbcUtils.getConnection();
		//获取statement
		Statement stat = conn.createStatement();
		//利用statement执行sql语句
		ResultSet rs = stat.executeQuery("SELECT * from course where state="+state+"");//获取查询出来的结果集
		
        
      //循环结果集，把每数据赋给课程对象，然后将课程对象放在集合里，循环执行
        List<CourseP> list = new ArrayList<CourseP>();
		while(rs.next()) {//循环每一条数据
			CourseP courseP = new CourseP();//创建对象
			
				//把每条数据的具体属性（字段）赋给对象中的对应属性
				courseP.setId(Integer.parseInt(rs.getString("id")));
				courseP.setCourse_name(rs.getString("course_name"));
				courseP.setPrice(rs.getString("price"));
				courseP.setTeacher(rs.getString("teacher"));
				courseP.setDate(rs.getString("date"));
				courseP.setDesc1(rs.getString("desc1"));
				courseP.setDesc2(rs.getString("desc2"));
			
			//把对象添加到集合	
			list.add(courseP);
		}
		//把集合返回
		return list;
	}
	
		//根据id查询课程
		public static CourseP getCourseById(String id) throws SQLException {
			//利用jdbc工具得到connection
			Connection conn = JdbcUtils.getConnection();
			//获取statement
			Statement stat = conn.createStatement();
			//利用statement执行sql语句
			ResultSet rs = stat.executeQuery("SELECT * from course where id="+id+"");//获取查询出来的结果集
			CourseP courseP = new CourseP();
			while(rs.next()) {
					courseP.setId(Integer.parseInt(rs.getString("id")));
					courseP.setCourse_name(rs.getString("course_name"));
					courseP.setPrice(rs.getString("price"));
					courseP.setTeacher(rs.getString("teacher"));
					courseP.setDate(rs.getString("date"));
					courseP.setDesc1(rs.getString("desc1"));
					courseP.setDesc2(rs.getString("desc2"));
					//因为根据id查出来只有一条，所以循环只会执行一次，也不用list集合
			}
			//System.out.println(courseP);
			return courseP;
		}
		
		//修改课程状态(下架或者激活)
		public String modify(String id,String state) throws SQLException {
			//利用jdbc工具得到connection
			Connection conn = JdbcUtils.getConnection();
			//获取statement
			Statement stat = conn.createStatement();
			//利用statement执行sql语句
			int res = stat.executeUpdate("UPDATE course SET state="+state+" where id="+id+"");
			return res+"";
		}
		
}
