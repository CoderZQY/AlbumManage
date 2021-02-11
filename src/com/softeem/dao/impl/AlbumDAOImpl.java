package com.softeem.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.softeem.dao.AlbumDAO;
import com.softeem.dao.PhotoDAO;
import com.softeem.pp.dbutil.DBConnection;
import com.softeem.pp.dto.Album;


public class AlbumDAOImpl implements AlbumDAO{

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	/**
	 * 相册添加
	 */
	public boolean addAlbum(Album a) {
		String sql = "insert into tb_album(a_name,a_createtime,a_discription,u_id) values(?,?,?,?)";
		try {
			//获取连接
			conn = DBConnection.getConn();
			//获得预处理命令
			ps = conn.prepareStatement(sql);
			//预处理
			ps.setString(1,a.getAname());
			ps.setDate(2,new Date(System.currentTimeMillis()));
			ps.setString(3, a.getAdiscription());
			ps.setInt(4, a.getUid());
			//执行
			int i = ps.executeUpdate();
			if(i>0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnection.close(null, ps, conn);
		}
		
		return false;
	}

	public Album getNowAlbum() {
		String sql = "select * from tb_album where a_id=(select max(a_id) from tb_album)";
		Album a = null;
		try {
			conn = DBConnection.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				//查询到对应的记录,则创建相册对象
				a = new Album();
				a.setAid(rs.getInt(1));
				a.setAcreateTime(rs.getDate("a_createtime"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return a;
	}

	public List<Album> findAlbumByUid(int uid) {
		String sql = "select * from tb_album where u_id=?";
		//创建一个集合用于存放查询到的所有相册
		List<Album> list = new ArrayList<Album>();
		try {
			conn = DBConnection.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			rs = ps.executeQuery();
			while(rs.next()){
				//如果遍历到一条记录,说明查询到一条记录
				Album a = new Album();
				//将遍历到的对象的属性赋值给新建的相册对象
				a.setUid(rs.getInt("u_id"));
				a.setAcreateTime(rs.getDate("a_createtime"));
				a.setAname(rs.getString("a_name"));
				a.setAdiscription(rs.getString("a_discription"));
				a.setAid(rs.getInt("a_id"));
				//将当前记录添加到集合中
				list.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	/**
	 * 分页查询
	 */
	public List<Album> findAlbumByUid(int uid, int pageSize, int currentPage) {
		String sql = "select * from tb_album where u_id=? limit ?,?";
		List<Album> list = new ArrayList<Album>();
		try {
			conn = DBConnection.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			ps.setInt(2, (currentPage-1)*pageSize);
			ps.setInt(3, pageSize);
			rs = ps.executeQuery();
			while(rs.next()){
				Album a = new Album();
				a.setAid(rs.getInt("a_id"));
				a.setAname(rs.getString("a_name"));
				a.setAdiscription(rs.getString("a_discription"));
				a.setAcreateTime(rs.getDate("a_createtime"));
				a.setUid(uid);
				//将当前查询到的相册存放到集合中
				list.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return list;
	}

	/**
	 * 获取当前用户相册的总页数
	 */
	public int getTotalPage(int uid,int pageSize) {
		//总页数
		int totalPage = 0;
		//总记录条数
		int totalNum = 0;
		String sql = "select count(*) from tb_album where u_id=?";
		try {
			conn = DBConnection.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			rs = ps.executeQuery();
			if(rs.next()){
				totalNum = rs.getInt(1);
			}
			//判断总记录数能否除尽每页大小
			if(totalNum % pageSize == 0){
				totalPage = totalNum/pageSize;
			}else{
				totalPage = totalNum/pageSize+1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return totalPage;
	}

	/**
	 * 删除相册
	 * 事物:原子性,一致性,隔离性,安全性
	 */
	public boolean delAlbum(int aid) {
		//先删除当前相册中的照片
		PhotoDAO pdao = new PhotoDAOImpl();
		boolean f = pdao.delPhotoByAid(aid);
		//如果照片删除成功,才继续执行删除相册
		if(f){
			String sql = "delete from tb_album where a_id=?";
			try {
				conn = DBConnection.getConn();
				ps = conn.prepareStatement(sql);
				ps.setInt(1, aid);
				int i = ps.executeUpdate();
				if(i>0){
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	public Album getAlbum(int aid) {
		String sql = "select * from tb_album where a_id=?";
		Album a = null;
		try {
			conn = DBConnection.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, aid);
			rs = ps.executeQuery();
			if(rs.next()){
				a = new Album();
				a.setAname(rs.getString("a_name"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return a;
	}

}
