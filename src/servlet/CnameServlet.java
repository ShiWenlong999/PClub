package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.CnameJdbc;

/**
 * Servlet implementation class Cname
 */
@WebServlet("/Cname")
public class CnameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CnameServlet() {
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
		request.setCharacterEncoding("UTF-8");//解决ajax请求时中文参数乱码，
		//获取到前端发来的报名请求，以及报名信息参数
		String cname = request.getParameter("cname");
		String uname = request.getParameter("uname");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String phone = request.getParameter("phone");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
       String date = df.format(new Date());// new Date()为获取当前系统时间为报名时间
		//创建jdbc对象，调用其中的方法
		CnameJdbc cnameJdbc = new CnameJdbc();
		
		try {
			String res = cnameJdbc.addCname(uname, cname, sex, age, phone,date);
			response.getWriter().write(res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
