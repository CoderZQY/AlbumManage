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

public class ShowPhotoByAlbumServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			//获取当前相册编号
			String id = request.getParameter("aid");
			int aid = Integer.parseInt(id);
			//获取当前页
			String cp = request.getParameter("currentPage");
			int currentPage = Integer.parseInt(cp);
			//判断当前页是否小于1
			if(currentPage<1){
				currentPage=1;
			}
			//获得照片的数据访问对象
			PhotoDAO pdao = new PhotoDAOImpl();
			int totalPage = pdao.getTotalPage(aid, 8);
			//判断当前页是否大于总页数
			if(currentPage>totalPage){
				currentPage = totalPage;
			}
			//调用查询照片的方法
			List<Photo> list = pdao.findByAid(aid, 8, currentPage);
			
			request.setAttribute("aid",aid);
			if(list.size()<1){
				request.getRequestDispatcher("noresults.jsp").forward(request, response);
			}else{
				request.setAttribute("totalPage", totalPage);
				request.setAttribute("currentPage", currentPage);
				//将查询到的图片的集合设置到下个页面中
				request.setAttribute("list", list);
				//页面跳转
				request.getRequestDispatcher("showPhotoByAlbum.jsp").forward(request, response);
			}
	}

}
