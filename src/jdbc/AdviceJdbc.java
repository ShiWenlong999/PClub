package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pojo.Advice;
import pojo.CourseP;

public class AdviceJdbc {

	//添加意见
	public void addAdvice(String uname,String advice,String contact) throws SQLException{
				//利用jdbc工具得到connection
				Connection conn = JdbcUtils.getConnection();
				//获取statement
				Statement stat = conn.createStatement();
				//利用statement执行sql语句 ，将意见信息插入意见表
				int res = stat.executeUpdate("INSERT INTO advice(username,adv,contant) VALUES('"+uname+"','"+advice+"','"+contact+"')");
	}
	//查询意见表
	public List<Advice> getAdvices() throws SQLException{
		//利用jdbc工具得到connection
		Connection conn = JdbcUtils.getConnection();
		//获取statement
		Statement stat = conn.createStatement();
		//利用statement执行sql语句
				ResultSet rs = stat.executeQuery("SELECT * from advice");//获取查询出来的结果集
				
		        
		      //循环结果集，把每数据赋给对象，然后将对象放在集合里，循环执行
		        List<Advice> list = new ArrayList<Advice>();
				while(rs.next()) {//循环每一条数据
					Advice advice = new Advice();//创建对象
					
					//把每条数据的具体属性（字段）赋给对象中的对应属性
					advice.setUsername(rs.getString("username"));  //数据库里面的username字段给了advice对象username属性
					advice.setAdv(rs.getString("adv"));
					advice.setContant(rs.getString("contant"));;
					
					//把对象添加到集合	
					list.add(advice);
				}
				//把集合返回
				return list;
	}
}
