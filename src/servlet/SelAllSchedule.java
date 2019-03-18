package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import jdbc.Course;
import jdbc.ScheduleJdbc;
import pojo.Schedule;

/**
 * Servlet implementation class SelAllSchedule
 */
@WebServlet("/SelAllSchedule")
public class SelAllSchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelAllSchedule() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Content-type", "text/html;charset=UTF-8");//处理乱码。因为传递中文参数，如果不对参数进行处理的话，传到前端会变成乱码
		String state = request.getParameter("state");
		//创建jdbc对象以便调用里面的对应的方法
		ScheduleJdbc scheduleJdbc = new ScheduleJdbc();
		//创建Gson用于把集合转换成json对象，以便前端js可以解析返回结果
				Gson gson = new Gson();
		 try {
			List<Schedule> list = scheduleJdbc.selAllSchedule(state);
			response.getWriter().write(gson.toJson(list));
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
