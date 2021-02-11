package com.softeem.pp.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * java连接数据库六大步骤(java database connectivity):
 * 1.加载驱动
 * 2.获取连接
 * 3.获得执行命令
 * 4.执行
 * 5.结果处理
 * 6.释放资源(关闭资源)
 * @author 张庆洋
 */
public class DBConnection {

	private static final String CLASSDRIVER="com.mysql.cj.jdbc.Driver";
	private static final String URL="jdbc:mysql://127.0.0.1:3306/pp?serverTimezone=UTC";
	private static final String USERNAME="root";
	private static final String PASSWORD="qingyang1234";
	
	//1.加载驱动
	static{
		//DriverManager.registerDriver(new Driver());
		//System.setProperty("jdbc.Driver","com.mysql.jdbc.Driver");
		try {
			Class.forName(CLASSDRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//2.获取连接
	public static Connection getConn(){
		Connection conn = null;
		//shift+alt+x转大写 shift+alt+y转小写
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	//6.释放资源
	public static void close(ResultSet rs,PreparedStatement ps,Connection conn){
		
		try {
			if(rs != null){
				rs.close();
			}
			if(ps != null){
				ps.close();
			}
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
