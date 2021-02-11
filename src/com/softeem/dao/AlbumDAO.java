package com.softeem.dao;

import java.util.List;

import com.softeem.pp.dto.Album;

public interface AlbumDAO {

	/**
	 * �½����
	 * @param a
	 * @return
	 */
	public boolean addAlbum(Album a);
	
	/**
	 * ��ѯ��ǰ��ӵ������Ϣ
	 */
	public Album getNowAlbum();
	
	/**
	 * List Set Map������
	 * �����û�Id��ѯ��ǰ�û����е����
	 * ���ڻ�ȡ�����
	 * @param uid
	 * @return
	 */
	public List<Album> findAlbumByUid(int uid);
	
	/**
	 * ��ѯ��ǰ�û���������Ტ��ҳ
	 * @param uid
	 * @param pageSize
	 * @param currentPage
	 * @return
	 */
	public List<Album> findAlbumByUid(int uid, int pageSize, int currentPage);
	
	/**
	 * ��ȡ��ҳ��
	 * @param pageSize
	 * @return
	 */
	public int getTotalPage(int uid, int pageSize);
	
	/**
	 * ɾ��ָ�����
	 * @param aid
	 * @return
	 */
	public boolean delAlbum(int aid);
	
	/**
	 * ��������ID��ѯ��ǰ��������
	 * @param aid
	 * @return
	 */
	public Album getAlbum(int aid);
}
