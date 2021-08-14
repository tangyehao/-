package cn.com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.pojo.UserBean;
import cn.com.service.UserBeanServiceImpl;
import cn.com.service.UserBeanServiceInf;

public class UpdateServlet extends HttpServlet {
	private UserBeanServiceInf service;
	/**
		 * Constructor of the object.
		 */
	public UpdateServlet() {
		super();
		service = new UserBeanServiceImpl();
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String userPwd = request.getParameter("userPwd");
		String userPhone = request.getParameter("userPhone");
		String userEmail = request.getParameter("userEmail");
		String userAddress = request.getParameter("userAddress");
		String mText = request.getParameter("mText");
		String uId = request.getParameter("userId");
		int userId = Integer.parseInt(uId); 
		UserBean ub = new UserBean();
		ub.setUserpwd(userPwd);
		ub.setPhone(userPhone);
		ub.setEmail(userEmail);
		ub.setAddress(userAddress);
		ub.setMtext(mText);
		ub.setUserid(userId);
		if(service.updateUserInfo(ub)){
			request.setAttribute("msg","修改成功");
			request.setAttribute("allInfo", service.getAllUserInfo());
			request.getRequestDispatcher("list.jsp").include(request, response);
		}else{			
			request.setAttribute("msg","修改失败");
			//response.sendRedirect("updateList?userId="+userId);
			//1.包含转发
			request.getRequestDispatcher("updateUser?userId = "+userId).forward(request, response);
		}
	}

}
