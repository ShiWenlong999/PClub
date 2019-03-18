package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pojo.Cname;
import pojo.Schedule;
import pojo.Sname;

public class SnameJDBC {
	
	//增加赛程报名的方法
	public String addsname(String uname,String sname,String sex,String age,String phone,String date) throws SQLException {
		       //利用jdbc工具得到connection
				Connection conn = JdbcUtils.getConnection();
				//获取statement
				Statement stat = conn.createStatement();
				//利用statement执行sql语句 ，将报名信息插入到报名表
				int res = stat.executeUpdate("insert into user_schedule(username,schedulename,sex,age,phone,regdate) VALUES ('"+uname+"','"+sname+"','"+sex+"','"+age+"','"+phone+"','"+date+"')");
				return ""+res;

		
	}
	
	//查询赛程报名表
	public List<Sname> selSname() throws SQLException{
		//利用jdbc工具得到connection
		Connection conn = JdbcUtils.getConnection();
		//获取statement
		Statement stat = conn.createStatement();
		//利用statement执行sql语句
				ResultSet rs = stat.executeQuery("SELECT * from user_schedule");//获取查询出来的结果集
				
		        
		      //循环结果集，把每数据赋给对象，然后将对象放在集合里，循环执行
		        List<Sname> list = new ArrayList<Sname>();
				while(rs.next()) {//循环每一条数据
					Sname sname = new Sname();//创建对象
					
					//把每条数据的具体属性（字段）赋给对象中的对应属性
					sname.setSchedulename(rs.getString("schedulename"));
					sname.setUsername(rs.getString("username"));
					sname.setPhone(rs.getString("phone"));
					sname.setAge(rs.getString("age"));
					sname.setSex(rs.getString("sex"));
					sname.setRegdate(rs.getString("regdate"));
					//把对象添加到集合	
					list.add(sname);
				}
				//把集合返回
				return list;
	}

}
