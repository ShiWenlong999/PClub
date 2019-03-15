package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.AdviceJdbc;

/**
 * Servlet implementation class AddAdvice
 */
@WebServlet("/AddAdvice")
public class AddAdvice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAdvice() {
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
		//获取到前端发来的参数信息
		String username = request.getParameter("username");
		String adv = request.getParameter("adv");
		String contact = request.getParameter("contact");
		
		//创建Advice JDBC对象
		AdviceJdbc advJdbc = new AdviceJdbc();
		//调用JDBC的方法，添加意见
		
			try {
				advJdbc.addAdvice(username, adv, contact);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
