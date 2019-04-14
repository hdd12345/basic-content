package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.User;

public interface UserMapper {
	//����û�
	public void insertUser(User user) throws Exception;
	//����id��ѯ�û�
	public User selectUserById(int id) throws Exception;
	//����idɾ���û�
	public void deleteUserByid(int id) throws Exception;
	//��ѯ�����û�
	public List<User> selectAllUser() throws Exception;
	//�޸��û���Ϣ
	public void updateUser(User user) throws Exception;
	//�������
	public void update1(@Param("uuu") String username,@Param("ppp") String password) throws Exception;
}
