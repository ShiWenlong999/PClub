package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.Course;

/**
 * Servlet implementation class AddCourse
 */
@WebServlet("/AddCourse")
public class AddCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取前端发来的参数
		String cname = request.getParameter("cname"); //将前端发送过来的cname赋值给cname
		String price = request.getParameter("price");
		String teacher = request.getParameter("teacher");
		String date = request.getParameter("date");
		String desc1 = request.getParameter("desc1");
		String desc2 = request.getParameter("desc2");
		//创建课程jdbc对象实例，以便调用其中的方法
		Course course =new Course();
		try {
			String res = course.addCourse(cname, price, teacher, date, desc1, desc2);
			response.getWriter().write(res); //将结果res返回给前端页面
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
