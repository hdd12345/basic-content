package com.cakeshop.service;

import com.cakeshop.entity.User;

public interface UserService {
	// �����û�
	public int insertUser(User user) throws Exception;

	// ��ѯ�û������ڵ�¼��
	public User selectUser(User user) throws Exception;

	// ��ѯ�û����������û������أ�
	public int selectUserName(String username) throws Exception;

	// �ı��û�״̬����Ҫ�����û��˺ż��
	public int updateState(String code) throws Exception;

	// �����û�����
	public int updateUser(User user) throws Exception;

	// ��ѯ�û��������������룩
	public int selectUserNameLogin(String username) throws Exception;

	// �������루�����������룩
	public int resetPassword(String code) throws Exception;

}
