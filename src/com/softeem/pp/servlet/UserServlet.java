package com.softeem.pp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softeem.dao.UserDAO;
import com.softeem.dao.impl.UserDAOImpl;
import com.softeem.pp.dto.User;

public class UserServlet extends HttpServlet{

	// alt+/
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			doPost(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			//req.setCharacterEncoding("utf-8");
			UserDAO udao = new UserDAOImpl();
			//获取请求功能
			String op = req.getParameter("operation");
			if("register".equals(op)){
				//获取前台表单中的信息
				String name = req.getParameter("username");
				String pass = req.getParameter("password");
				User u = new User();
				u.setUname(name);
				u.setUpass(pass);
				boolean b = udao.register(u);
				if(b){
					//注册成功
					req.setAttribute("msg","<font color='green'>注册成功,请输入用户名密码登陆</font>");
					//跳转
				}else{
					//注册失败
					req.setAttribute("msg", "注册失败,请检查!");
					//跳转
				}
				req.getRequestDispatcher("loginAndRegister.jsp").forward(req, resp);
			}else{
				//登陆功能
				//获取前台表单中的信息
				String name = req.getParameter("username");
				String pass = req.getParameter("password");
				User user = udao.login(name);
				if(user != null){
					//判断前台传过来的密码和后台数据库中的密码是否一致
					if(user.getUpass().equals(pass)){
						//登陆成功
						//将当前用户保存到session中
						req.getSession().setAttribute("user", user);
						req.getRequestDispatcher("main.jsp").forward(req, resp);
					}else{
						//密码错误
						req.setAttribute("msg", "密码错误!");
						req.getRequestDispatcher("loginAndRegister.jsp").forward(req, resp);
					}
				}else{
					//用户不存在
					req.setAttribute("msg", "用户不存在");
					req.getRequestDispatcher("loginAndRegister.jsp").forward(req, resp);
				}
			}
	}
}
