package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import jdbc.ScheduleJdbc;
import pojo.Schedule;

/**
 * Servlet implementation class SelSchedule
 */
@WebServlet("/SelSchedule")
public class SelSchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelSchedule() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Content-type", "text/html;charset=UTF-8");//处理乱码
		String id = request.getParameter("id");//获取前端传来的id
		//创建JDBC对象
		ScheduleJdbc scheduleJdbc = new ScheduleJdbc();
		//创建JSON对象
		Gson gson =new Gson();
	    //调用JDBC里面的方法
		try {
			Schedule res = scheduleJdbc.getScheduleById(id);
			response.getWriter().write(gson.toJson(res));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
