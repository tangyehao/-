package cn.com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;

import cn.com.pojo.UserBean;
import cn.com.service.UserBeanServiceImpl;
import cn.com.service.UserBeanServiceInf;
import java.util.List;

public class LoginServlet extends HttpServlet {
	private UserBeanServiceInf service;
	
	public LoginServlet() {
		// TODO Auto-generated constructor stub
		service = new UserBeanServiceImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doPost(request,response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");		
		String userName = request.getParameter("userName");
		String userPwd = request.getParameter("userPwd");
		HttpSession session = request.getSession();
		if(service.validateByUserNameAndPwd(userName, userPwd)){
			UserBean ub = service.getUserInfoByName(userName);
			List<UserBean> list = service.getAllUserInfo();
			session.setAttribute("uInfo", ub);
			session.setAttribute("userName", ub.getUsername());
			request.setAttribute("allInfo", list);
			//resp.sendRedirect("list");
			request.getRequestDispatcher("list.jsp").include(request, response);
		}else{
			request.setAttribute("msg", "’ ∫≈ªÚ√‹¬Î¥ÌŒÛ");
			request.getRequestDispatcher("login.jsp").include(request, response);
			return;
		}
	}
	
}
