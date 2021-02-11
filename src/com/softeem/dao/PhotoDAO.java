package com.softeem.dao;

import java.util.List;

import com.softeem.pp.dto.Photo;

public interface PhotoDAO {

	/**
	 * �����Ƭ
	 * @param p
	 * @return
	 */
	public boolean addPhoto(Photo p);

	/**
	 * �������IDɾ����Ƭ
	 * @param aid
	 * @return
	 */
	public boolean delPhotoByAid(int aid);
	
	/**
	 * ��������ID��ѯ��ǰ����е�������Ƭ���ҷ�ҳ
	 * @param aid
	 * @param pageSize
	 * @param currentPage
	 * @return
	 */
	public List<Photo> findByAid(int aid, int pageSize, int currentPage);

	/**
	 * ������Ƭ��IDɾ����Ƭ
	 * @param pid
	 * @return
	 */
	public boolean delPhotoByPid(int pid);
	
	/**
	 * ��ѯ��ǰ�����ָ��ÿҳ��С�����ҳ��
	 * @param aid
	 * @param pageSize
	 * @return
	 */
	public int getTotalPage(int aid, int pageSize);
	
	/**
	 * ��ѯָ��ID����Ƭ
	 * @param pid
	 * @return
	 */
	public Photo findByPid(int pid);
	
	/**
	 * ��ȡ��Ƭ����
	 * @param aid
	 * @return
	 */
	public int getTotalNum(int aid);
	
	/**
	 * ��ѯ����������е���Ƭ
	 * @param aid
	 * @return
	 */
	public List<Photo> findAll(int aid);
	
	/**
	 *  ����������ѯ������������Ƭ��Ϣ
	 * @param sql
	 * @param pageSize
	 * @param currentPage
	 * @return
	 */
	public List<Photo> queryPhoto(String sql, int pageSize, int currentPage);

	/**
	 * ��ȡ������������ҳ��
	 * @param sql
	 * @param pageSize
	 * @return
	 */
	public int getTotalPage(String sql, int pageSize);
}
