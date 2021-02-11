package com.softeem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.softeem.dao.UserDAO;
import com.softeem.pp.dbutil.DBConnection;
import com.softeem.pp.dto.User;

public class UserDAOImpl implements UserDAO {

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	/**
	 * 用户登陆
	 */
	public User login(String username) {
		String sql = "select * from tb_user where u_name=?";
		User user = null;
		try {
			//获取连接
			conn = DBConnection.getConn();
			//获得预处理命令
			ps = conn.prepareStatement(sql);
			//预处理
			ps.setString(1, username);
			//执行
			rs = ps.executeQuery();
			if(rs.next()){
				user = new User();
				user.setUid(rs.getInt("u_id"));
				user.setUname(rs.getString("u_name"));
				user.setUpass(rs.getString("u_pass"));
				user.setUflag(rs.getInt("u_flag"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//预处理
		
		
		return user;
	}

	/**
	 * 用户注册
	 */
	public boolean register(User user) {
		String sql = "insert into tb_user(u_name,u_pass) values(?,?)";
		try {
			//获取连接
			conn = DBConnection.getConn();
			//获得预处理命令
			ps = conn.prepareStatement(sql);
			//预处理
			ps.setString(1, user.getUname());
			ps.setString(2, user.getUpass());
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

	public boolean updatePass(int uid, String upass) {
		String sql = "update tb_user set u_pass=? where u_id=?";
		try {
			//获取连接
			conn = DBConnection.getConn();
			//获得预处理命令
			ps = conn.prepareStatement(sql);
			//预处理
			ps.setString(1, upass);
			ps.setInt(2, uid);
			//执行
			int i = ps.executeUpdate();
			if(i>0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnection.close(rs, ps, conn);
		}
		return false;
	}

	/**
	 * 查询出所有用户
	 */
	public List<User> findAllUser(int pageSize,int currentPage) {
		String sql = "select * from tb_user limit ?,?";
		List<User> list = new ArrayList<User>();
		
		try {
			conn = DBConnection.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (currentPage-1)*pageSize);
			ps.setInt(2, pageSize);
			rs = ps.executeQuery();
			while(rs.next()){
				User u = new User();
				u.setUid(rs.getInt("u_id"));
				u.setUname(rs.getString("u_name"));
				u.setUflag(rs.getInt("u_flag"));
				list.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}

	public int getTotalPage(int pageSize) {
		String sql = "select count(*) from tb_user";
		int totalNum = 0;
		int totalPage = 0;
		try {
			conn = DBConnection.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				totalNum = rs.getInt(1);
			}
			if(totalNum%pageSize == 0){
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
}
