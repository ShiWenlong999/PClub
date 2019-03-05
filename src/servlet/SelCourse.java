package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import jdbc.Course;
import pojo.CourseP;

/**
 * Servlet implementation class SelCourse
 */
@WebServlet("/SelCourse")
public class SelCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelCourse() {
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
		//获取状态参数，
		String id = request.getParameter("id");
		//创建Course jdbc对象以便调用里面的对应的方法
		Course course = new Course();
				
		//创建Gson用于把对象转换成json对象，以便前端js可以解析返回结果
		Gson gson = new Gson();
		try {
			//调用course中查询数据库方法获取查询结果，并把结果返回到前端
			CourseP courseP = course.getCourseById(id);
			response.getWriter().write(gson.toJson(courseP));//括号中意思：用Gson把课程对象转换成json对象
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
