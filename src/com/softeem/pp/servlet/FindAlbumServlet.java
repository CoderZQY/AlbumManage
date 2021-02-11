package com.softeem.pp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softeem.dao.AlbumDAO;
import com.softeem.dao.impl.AlbumDAOImpl;
import com.softeem.pp.dto.Album;

public class FindAlbumServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request,response);
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			//将响应信息的编码设置为utf-8
			response.setCharacterEncoding("utf-8");
			//设置HTTP响应头信息
			response.setHeader("contextType", "html/text;charset=utf-8");
			
			//获取相册ID
			String id = request.getParameter("aid");
			int aid = Integer.parseInt(id);
			
			AlbumDAO adao = new AlbumDAOImpl();
			Album a = adao.getAlbum(aid);
			String aname = a.getAname();
			
			PrintWriter pw = new PrintWriter(response.getWriter());
			pw.println(aname);
			pw.flush();
	}

}
