package cn.com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import cn.com.pojo.UserBean;
import cn.com.service.UserBeanServiceImpl;
import cn.com.service.UserBeanServiceInf;

public class AddServlet extends HttpServlet {
	private UserBeanServiceInf service;

	/**
	 * Constructor of the object.
	 */
	public AddServlet() {
		super();
		service = new UserBeanServiceImpl();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String userName = request.getParameter("userName");		
		if(service.getUserInfoByName(userName) != null){
			request.setAttribute("msg","帐号重复，请重新输入");
			request.getRequestDispatcher("regist.jsp").include(request, response);
			return;
		}
		String userEPwd = request.getParameter("userEPwd");
		String userPhone = request.getParameter("userPhone");
		String userEmail = request.getParameter("userEmail");
		String userAddress = request.getParameter("userAddress");
		String mText = request.getParameter("mText");
		UserBean ub = new UserBean();
		ub.setUsername(userName);
		ub.setUserpwd(userEPwd);
		ub.setPhone(userPhone);
		ub.setEmail(userEmail);
		ub.setAddress(userAddress);
		ub.setMtext(mText);
		
		if(service.validateByUserName(userName)){
			request.setAttribute("msg","帐号重复，请重新输入");
			request.getRequestDispatcher("regist.jsp").include(request, response);
			return;
		}
		
		if (service.addUserInfo(ub)) {
			request.setAttribute("msg","注册成功");
			request.setAttribute("userName",ub.getUsername());
			request.setAttribute("allInfo", service.getAllUserInfo());
			request.getRequestDispatcher("login.jsp").include(request, response);
			return;
		} else {
			request.setAttribute("msg","注册失败");
			request.getRequestDispatcher("regist.jsp").include(request, response);
			return;
		}
	}
}
