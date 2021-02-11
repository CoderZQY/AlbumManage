package com.softeem.pp.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softeem.dao.AlbumDAO;
import com.softeem.dao.impl.AlbumDAOImpl;
import com.softeem.pp.dto.Album;
import com.softeem.pp.dto.User;

public class AddAlbumServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			AlbumDAO adao = new AlbumDAOImpl();
			//获取前台表单中相册基本信息
			String aname = request.getParameter("aname");//相册名
			String adis = request.getParameter("adiscription");//相册描述
			//获取创建相册的用户
			User user = (User)request.getSession().getAttribute("user");
			int uid = user.getUid();//用户id
			//创建相册
			Album a = new Album();
			//为新建的相册赋上属性值
			a.setAname(aname);
			a.setAdiscription(adis);
			a.setUid(uid);
			//执行添加相册
			boolean b = adao.addAlbum(a);
			//查询该相册的所有信息
			Album a2 = adao.getNowAlbum();
			a2.setAname(aname);
			a2.setAdiscription(adis);
			a2.setUid(uid);
			if(b){
				//相册创建成功
				request.setAttribute("a", a2);
				request.getRequestDispatcher("createSuccess.jsp").forward(request, response);
			}else{
				//失败
				request.setAttribute("msg", "创建失败,请检查");
				request.getRequestDispatcher("addAlbum.jsp").forward(request, response);
			}
	}

}
