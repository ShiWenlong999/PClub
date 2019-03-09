package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pojo.Advice;
import pojo.Cname;

public class CnameJdbc {

	//报名
	public String addCname(String uname,String cname,String sex,String age,String phone,String date) throws SQLException {
		//利用jdbc工具得到connection
		Connection conn = JdbcUtils.getConnection();
		//获取statement
		Statement stat = conn.createStatement();
		//利用statement执行sql语句 ，将报名信息插入到报名表
		int res = stat.executeUpdate("INSERT INTO user_course(username,coursename,sex,age,phone,regdate) VALUES('"+uname+"','"+cname+"','"+sex+"','"+age+"','"+phone+"','"+date+"')");
		return ""+res;
	}
	
	//查询课程报名表
		public List<Cname> getNameTable() throws SQLException{
			//利用jdbc工具得到connection
			Connection conn = JdbcUtils.getConnection();
			//获取statement
			Statement stat = conn.createStatement();
			//利用statement执行sql语句
					ResultSet rs = stat.executeQuery("SELECT * from user_course");//获取查询出来的结果集
					
			        
			      //循环结果集，把每数据赋给对象，然后将对象放在集合里，循环执行
			        List<Cname> list = new ArrayList<Cname>();
					while(rs.next()) {//循环每一条数据
						Cname cname= new Cname();//创建对象
						
						//把每条数据的具体属性（字段）赋给对象中的对应属性
						cname.setCoursename(rs.getString("coursename"));
						cname.setUsername(rs.getString("username"));
						cname.setPhone(rs.getString("phone"));
						cname.setAge(rs.getString("age"));
						cname.setSex(rs.getString("sex"));
						cname.setRegdate(rs.getString("regdate"));
						//把对象添加到集合	
						list.add(cname);
					}
					//把集合返回
					return list;
		}
}
