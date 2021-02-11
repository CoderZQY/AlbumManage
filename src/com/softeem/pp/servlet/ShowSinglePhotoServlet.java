package com.softeem.pp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softeem.dao.PhotoDAO;
import com.softeem.dao.impl.PhotoDAOImpl;
import com.softeem.pp.dto.Photo;

public class ShowSinglePhotoServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request,response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			String ida = request.getParameter("aid");
			String idp = request.getParameter("pid");
			int aid = Integer.parseInt(ida);
			int pid = Integer.parseInt(idp);
			PhotoDAO pdao = new PhotoDAOImpl();
			Photo p = pdao.findByPid(pid);
			//int count = pdao.getTotalNum(aid);
			List<Photo> photos = pdao.findAll(aid);
			if(p != null){
				request.setAttribute("photos",photos);
				//将照片对象传递到下个页面中
				request.setAttribute("p", p);
				request.getRequestDispatcher("ShowSinglePhoto.jsp").forward(request, response);
			}else{
				//照片不存在
			}
	}

}
