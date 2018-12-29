package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.LoginJdbc;
import jdbc.RegistJdbc;

/**
 * Servlet implementation class Regist
 */
@WebServlet("/Regist")
public class Regist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Regist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Content-type", "text/html;charset=UTF-8");//设置乱码
		String username = request.getParameter("username");//获取请求参数
		String password = request.getParameter("password");
		RegistJdbc rjdbc = new RegistJdbc();//创建对象
		//捕捉异常
		try {
			String flag = rjdbc.selUsername(username);//先去查询一遍数据库里有没有存在这个账号，0：没有，1：有
			if("0".equals(flag)) {//账号不存在，可以注册，
				String res = rjdbc.regist(username, password);//调用注册方法，获取返回参数
				response.getWriter().write(res);//响应给前端
			}else {//账号已经存在，直接给前端返回0
				response.getWriter().write("0");//响应给前端
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//response.getWriter().write("呀呀呀！");
	}

}
