package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.LoginJdbc;
import pojo.User;

/**
 * Servlet implementation class SetPass
 */
@WebServlet("/SetPass")
public class SetPass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetPass() {
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
		//1接收前端传来的参数，用户id,原始密码，新密码
		String username = request.getParameter("username");
		String oldPass = request.getParameter("oldPass");
		String newPass = request.getParameter("newPass");
		
		//接收到参数后先查询原始密码是否正确，正确继续修改密码，否则直接返回“2”代表原始密码错误，不再继续执行修改
		LoginJdbc jj = new LoginJdbc();//创建LoginJdbc对象，为了用它的方法
		try {
			User user = jj.getUserBya(username);//根据账号查询数据库，得到用户对象
			if(user.getPassword().equals(oldPass)) {//判断jdbc返回的用户的密码是否等于前端传过来的 .equals用来判断是否相等
				//原始密码和数据库密码相同，可以修改密码
				String res = jj.setPass(username, newPass);
				response.getWriter().write(res);
			}else {
				//用户输入的原始密码和数据库密码不同，返回“2”
				response.getWriter().write("2");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
