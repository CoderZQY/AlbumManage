package com.softeem.pp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softeem.dao.UserDAO;
import com.softeem.dao.impl.UserDAOImpl;
import com.softeem.pp.dto.User;

public class ShowUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			String cp = request.getParameter("currentPage");
			int currentPage = Integer.parseInt(cp);
			if(currentPage<1){
				currentPage = 1;
			}
			
			UserDAO udao = new UserDAOImpl();
			int totalPage = udao.getTotalPage(10);
			
			if(currentPage>totalPage){
				currentPage = totalPage;
			}
			
			List<User> list = udao.findAllUser(10, currentPage);
			
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("showAllUser.jsp").forward(request, response);
	}

}
