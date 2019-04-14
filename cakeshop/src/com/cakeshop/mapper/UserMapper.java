package com.cakeshop.mapper;

import org.springframework.stereotype.Repository;

import com.cakeshop.entity.User;

public interface UserMapper {
	// �����û�
	public int insertUser(User user) throws Exception;

	// ��ѯ�û������ڵ�¼��
	public User selectUser(User user) throws Exception;

	// ��ѯ�û����������û�������,���������ȡuser����
	public User selectUserName(String username) throws Exception;

	// �ı��û�״̬����Ҫ�����û��˺ż��
	public int updateState(String code) throws Exception;

	// �����û�
	public int updateUser(User user) throws Exception;

	// ��������Ϊ123456
	public int updatePassword(String code) throws Exception;

}