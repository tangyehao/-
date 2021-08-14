package cn.com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.pojo.UserBean;
import cn.com.service.UserBeanServiceImpl;
import cn.com.service.UserBeanServiceInf;

public class SearchServlet extends HttpServlet {
	private UserBeanServiceInf service;
	public SearchServlet(){
		super();
		service = new UserBeanServiceImpl();
	}
	
	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String userName = request.getParameter("userName");
		if(userName == null){
			request.setAttribute("allInfo", service.getAllUserInfo());
			request.getRequestDispatcher("list.jsp").forward(request, response);
			return;
		}
		request.setAttribute("allInfo", service.searchByName(userName));
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}
}
