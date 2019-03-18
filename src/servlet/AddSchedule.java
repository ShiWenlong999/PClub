package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.Course;
import jdbc.ScheduleJdbc;
import pojo.Schedule;

/**
 * Servlet implementation class AddSchedule
 */
@WebServlet("/AddSchedule")
public class AddSchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSchedule() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //获取前端发来的参数
				String sname = request.getParameter("sname"); //将前端发送过来的sname，将值赋给string类型的sname
				String price = request.getParameter("price");
				String date = request.getParameter("date");
				String prize = request.getParameter("prize");
				String sponsor= request.getParameter("sponsor");
                String desc1 = request.getParameter("desc1");
				String desc2 = request.getParameter("desc2");
				//创建赛程jdbc对象实例，以便调用其中的方法
				ScheduleJdbc scheduleJdbc = new ScheduleJdbc();
				
				try {
					String res = scheduleJdbc.addschedule(sname, price, date, prize, sponsor, desc1, desc2);
					response.getWriter().write(res);
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
