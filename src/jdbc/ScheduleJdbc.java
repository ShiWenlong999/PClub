package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pojo.Schedule;

public class ScheduleJdbc {

	//新增赛程方法
	public String addschedule(String sname,String price,String date,String prize,String sponsor,String desc1,String desc2) throws SQLException {
		        //利用jdbc工具得到connection
				Connection conn = JdbcUtils.getConnection();
				//获取statement
				Statement stat = conn.createStatement();
				//利用statement执行sql语句 ，
				int res = stat.executeUpdate("INSERT INTO schedule(name,price,date,prize,sponsor,desc1,desc2) VALUES('"+sname+"','"+price+"','"+date+"','"+prize+"','"+sponsor+"','"+desc1+"','"+desc2+"') ");
		return ""+res;
	}
	
	//查询所有赛程
	public List<Schedule> selAllSchedule(String state) throws SQLException{
		 //利用jdbc工具得到connection
		Connection conn = JdbcUtils.getConnection();
		//获取statement
		Statement stat = conn.createStatement();
		//利用statement执行sql语句 ，
		ResultSet rs = stat.executeQuery("SELECT * from schedule WHERE state = '"+state+"'");
		//创建集合，
		List<Schedule> list = new ArrayList<Schedule>();
		//循环结果集rs
		while(rs.next()) {
			//创建一个赛程对象，用于每次循环的内容赋给对象
			Schedule schedule = new Schedule();
			schedule.setId(Integer.parseInt(rs.getString("id")));
			schedule.setName(rs.getString("name"));
			schedule.setPrice(rs.getString("price"));
			schedule.setPrize(rs.getString("prize"));
			schedule.setSponsor(rs.getString("sponsor"));
			schedule.setDate(rs.getString("date"));
			schedule.setDesc1(rs.getString("desc1"));
			schedule.setDesc2(rs.getString("desc2"));
			//把对象添加到集合	
			list.add(schedule);
			
		}
		return list;
	}
	
	//修改赛程状态
	public String  modifySchedule(String state,String id) throws SQLException {
		 //利用jdbc工具得到connection
		Connection conn = JdbcUtils.getConnection();
		//获取statement
		Statement stat = conn.createStatement();
		//利用statement执行sql语句 ，
		int res = stat.executeUpdate("UPDATE schedule SET state="+state+" where id="+id);
		
		return ""+res;
	}
	//根据id查询赛程
	public Schedule getScheduleById(String id) throws SQLException {
		        //利用jdbc工具得到connection
				Connection conn = JdbcUtils.getConnection();
				//获取statement
				Statement stat = conn.createStatement();
				//利用statement执行sql语句 ，
				ResultSet rs = stat.executeQuery("SELECT * FROM schedule WHERE id="+id);
			    Schedule schedule = new Schedule();
			    //循环结果集
			    while(rs.next()) {
			    	schedule.setName(rs.getString("name"));
			    	schedule.setPrice(rs.getString("price"));
			    	schedule.setDate(rs.getString("date"));
			    	schedule.setPrize(rs.getString("prize"));
			    	schedule.setSponsor(rs.getString("sponsor"));
			    	schedule.setDesc2(rs.getString("desc2"));
			    	
			    }
			    	
			    
			    
				
			return schedule;
		
	}
	
}
