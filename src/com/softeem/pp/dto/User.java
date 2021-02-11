package com.softeem.pp.dto;

//开发要求:30%注释;70%代码
public class User {
	
	private int uid;//用户ID
	private String uname;//用户名
	private String upass;//密码
	private int uflag;//标识位(标识当前用户是管理员还是普通用户)

	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public int getUflag() {
		return uflag;
	}
	public void setUflag(int uflag) {
		this.uflag = uflag;
	}
	
}
