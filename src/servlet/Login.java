package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.LoginJdbc;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		String account = request.getParameter("account");//获取前端请求的参数。将前端发送过来的account赋值给account
		String password = request.getParameter("password");
	//HttpServletRequest代表客户端的请求。HttpServletResponse对象代表服务器的响应。
		LoginJdbc jj = new LoginJdbc();//创建LoginJdbc对象，为了用它的方法。servlet创建jdbc对象,为了能调用JDBC方法
		String flag="0";
		try {
			flag = jj.login(account, password); //值赋给flag
			response.getWriter().write(flag);   //将JDBC查询成功的值返回给前端。
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//调用jdbc方法，返回参数
	}

}
