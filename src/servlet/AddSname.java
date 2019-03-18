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

import jdbc.SnameJDBC;

/**
 * Servlet implementation class AddSame
 */
@WebServlet("/AddSname")
public class AddSname extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSname() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//解决ajax请求时中文参数乱码，
		String sname = request.getParameter("sname");
		String uname = request.getParameter("uname");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String phone = request.getParameter("phone");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
       String date = df.format(new Date());// new Date()为获取当前系统时间为报名时间
       
       //创建jdbc对象
       SnameJDBC snamejdbc = new SnameJDBC();
       //调用方法，传入参数，接收返回值
       try {
		String res = snamejdbc.addsname(uname, sname, sex, age, phone, date);
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
