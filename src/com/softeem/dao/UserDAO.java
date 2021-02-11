package com.softeem.dao;

import java.util.List;

import com.softeem.pp.dto.User;

public interface UserDAO {

	/**
	 * �û�ע��
	 * @param user
	 * @return
	 */
	public boolean register(User user);
	
	/**
	 * �û���½
	 * @param username
	 * @return
	 */
	public User login(String username);
	
	/**
	 * �û������޸�
	 * @param uid
	 * @param upass
	 * @return
	 */
	public boolean updatePass(int uid, String upass);
	
	/**
	 * ��ѯ������
	 * @return
	 */
	public List<User> findAllUser(int pageSize, int currentPage);
	
	/**
	 * ��ѯ��ҳ��
	 * @return
	 */
	public int getTotalPage(int pageSize);
}
