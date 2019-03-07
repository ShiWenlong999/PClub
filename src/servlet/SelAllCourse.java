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
import pojo.CourseP;

/**
 * Servlet implementation class SelAllCourse
 */
@WebServlet("/SelAllCourse")
public class SelAllCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelAllCourse() {
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
		response.setHeader("Content-type", "text/html;charset=UTF-8");//设置乱码
		//获取状态参数，
		String state = request.getParameter("state");
		//创建Course jdbc对象以便调用里面的对应的方法
		Course course = new Course();
		
		//创建Gson用于把集合转换成json对象，以便前端js可以解析返回结果
		Gson gson = new Gson();
		try {
			//调用course中查询数据库方法获取查询结果，并把结果返回到前端
			List<CourseP> list = course.selCourse(state);
			response.getWriter().write(gson.toJson(list));//括号中意思：用Gson把集合转换成json对象
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
