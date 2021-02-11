package com.softeem.pp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.softeem.dao.PhotoDAO;
import com.softeem.dao.impl.PhotoDAOImpl;
import com.softeem.pp.dto.Photo;

public class PhotoUploadServlet extends HttpServlet {

	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			//获取图片上传到服务器的指定目录
			String rootPath = this.getInitParameter("rootpath");
			try {
				//创建SmartUpload对象
				SmartUpload su = new SmartUpload();
				//初始化上传环境
				su.initialize(this, request, response);
				//设置允许上传的文件最大值
				su.setMaxFileSize(1024*1024*10);//最大10M
				//设置允许上传文件的类型
				su.setAllowedFilesList("jpg,png,bmp,gif,emf");
				//开始上传
				su.upload();
				//获取所有文件
				Files files = su.getFiles();
				//获取单个文件
				File file = files.getFile(0);
				//获取文件名
				String filename = file.getFileName();//图片名称
				//保存文件(将传过来的文件复制到服务器存放文件的目录中)
				file.saveAs(rootPath+filename);
				
				//获取web元素
				Request req = su.getRequest();
				String id = req.getParameter("aid");
				int aid = Integer.parseInt(id);//获取相册ID
				String adis = req.getParameter("pdiscription");//获取相册描述信息
				//新建图片对象
				Photo p = new Photo();
				p.setAid(aid);
				p.setPname(filename);
				p.setPdiscription(adis);
				
				PhotoDAO pdao = new PhotoDAOImpl();
				boolean f = pdao.addPhoto(p);
				
				if(f){
					//上传成功
					request.getRequestDispatcher("ShowPhotoByAlbumServlet?aid="+aid+"&currentPage=1").forward(request, response);
				}else{
					//失败
				}
				
				
			} catch (SmartUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

}
