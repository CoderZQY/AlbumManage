package com.softeem.pp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softeem.dao.AlbumDAO;
import com.softeem.dao.impl.AlbumDAOImpl;
import com.softeem.pp.dto.Album;
import com.softeem.pp.dto.User;

public class FindAlbumByUserServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			//获取当前用户的操作
			String op = request.getParameter("op");
		
			//获取当前登陆用户
			User user = (User)request.getSession().getAttribute("user");
			//获得当前登陆用户的ID
			int uid = user.getUid();
			AlbumDAO adao = new AlbumDAOImpl();
			List<Album> list = null;
			if("showAlbum".equals(op)){
				
				//接收前台页面传过来的页码
				String cp = request.getParameter("currentPage");
				int currentPage = Integer.parseInt(cp);
				//如果获取到的当前页码数小于1则为当前页强行赋值为1
				if(currentPage<1){
					currentPage=1;
				}
				int totalPage = adao.getTotalPage(uid,8);
				//判断当前页是否大于总页数
				if(currentPage>totalPage){
					currentPage = totalPage;
				}
				//查询当前用户下所有的相册(分页/部分)
				list = adao.findAlbumByUid(uid, 8, currentPage);
				//将总页数传递到下个页面中
				request.setAttribute("totalPage", totalPage);
				//将当前页传递到下个页面中
				request.setAttribute("currentPage", currentPage);
				//将查询到的所有相册存放到request范围中
				request.setAttribute("list", list);
				//页面跳转
				request.getRequestDispatcher("showAlbum.jsp").forward(request, response);
			
			}else if("query".equals(op)){
				//查询照片时需要使用到的所有相册集合
				list = adao.findAlbumByUid(uid);
				//将查询到的所有相册存放到request范围中
				request.setAttribute("list", list);
				//页面跳转
				request.getRequestDispatcher("QueryPhoto.jsp").forward(request, response);
			}else{
				//添加照片时需要获得的所有相册名称
				
				list = adao.findAlbumByUid(uid);
				//将查询到的所有相册存放到request范围中
				request.setAttribute("list", list);
				//页面跳转
				request.getRequestDispatcher("addPhoto_main.jsp").forward(request, response);
			}
		}
		
}
