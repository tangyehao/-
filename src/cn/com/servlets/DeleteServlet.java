package cn.com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.pojo.UserBean;
import cn.com.service.UserBeanServiceImpl;
import cn.com.service.UserBeanServiceInf;

public class DeleteServlet extends HttpServlet {
	private UserBeanServiceInf service;

	/**
	 * Constructor of the object.
	 */
	public DeleteServlet() {
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
		String uId = request.getParameter("userId");
		HttpSession session = request.getSession();
		UserBean loginUser = (UserBean) session.getAttribute("uInfo");
		if(loginUser == null){
			response.addHeader("Refresh", "2,url=login.jsp");
			request.setAttribute("msg", "请先登录");
			return;
		}
		int userId = 0;
		try {
			userId = Integer.parseInt(uId);
			if (loginUser.getUserid() == userId) {
				request.setAttribute("msg", "您不能删自己");
				request.setAttribute("allInfo", service.getAllUserInfo());
				request.getRequestDispatcher("list.jsp").include(request, response);
				return;
			}
		} catch (NumberFormatException e) {
			// TODO: handle exception
			
				request.setAttribute("msg", "请按正常操作");
				request.setAttribute("allInfo", service.getAllUserInfo());
				request.getRequestDispatcher("list.jsp").include(request, response);
				return;
		}
		if (service.delUserInfoById(userId)) {
			request.setAttribute("msg", "删除成功");
			request.setAttribute("allInfo", service.getAllUserInfo());
			request.getRequestDispatcher("list.jsp").include(request, response);
		} else {
			request.setAttribute("msg", "删除失败");
			// response.sendRedirect("updateList?userId="+userId);
			// 1.包含转发
			request.getRequestDispatcher("list.jsp").include(request, response);
		}
		if(!service.validateByUserId(userId)){
			request.setAttribute("msg", "请按正常操作");
			return;
		}
		
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
