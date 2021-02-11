package com.softeem.pp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softeem.dao.UserDAO;
import com.softeem.dao.impl.UserDAOImpl;
import com.softeem.pp.dto.User;

public class UpdatePassWordServlet extends HttpServlet {

	//递归:间接递归;直接递归
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			//获取前台页面传到后台的原始密码
			String oldpass = request.getParameter("oldpass");
			//获得当前登陆用户的真实密码
			User user = (User)request.getSession().getAttribute("user");
			if(oldpass.equals(user.getUpass())){
				//密码匹配上
				//获取前台页面传过来的新密码
				String newpass = request.getParameter("newpass");
				UserDAO udao = new UserDAOImpl();
				boolean b = udao.updatePass(user.getUid(), newpass);
				if(b){
					//密码修改成功
					//将session中的用户密码更正,同时重新将用户信息设置到session中
					user.setUpass(newpass);
					request.getSession().setAttribute("user", user);
					request.setAttribute("success", "密码修改成功");
					request.getRequestDispatcher("updatePassword.jsp").forward(request, response);
				}else{
					//原始密码错误
					request.setAttribute("error", "密码修改失败");
					request.getRequestDispatcher("updatePassword.jsp").forward(request, response);
				}
			}else{
				//原始密码错误
				request.setAttribute("error", "原始密码不正确");
				request.getRequestDispatcher("updatePassword.jsp").forward(request, response);
			}
	}

}
