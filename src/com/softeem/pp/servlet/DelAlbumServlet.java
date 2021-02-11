package com.softeem.pp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softeem.dao.AlbumDAO;
import com.softeem.dao.impl.AlbumDAOImpl;

public class DelAlbumServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			//获得需要删除的相册的ID
			String id = request.getParameter("aid");
			int aid = Integer.parseInt(id);
			AlbumDAO adao = new AlbumDAOImpl();
			//调用相册的数据访问对象删除指定相册
			boolean b = adao.delAlbum(aid);
			//判断结果,页面跳转
			if(b){
				request.getRequestDispatcher("FindAlbumByUserServlet?op=showAlbum&currentPage=1").forward(request, response);
			}
	}

}
