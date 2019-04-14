package com.time.serviceImpl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.time.dao.UserMapper;
import com.time.entity.User;
import com.time.service.UserService;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
	@Resource(name = "userDao")
	private UserMapper userMapper;

	// 添加用户
	@Override
	public int insert(User user) {
		// TODO Auto-generated method stub
		return userMapper.insertSelective(user);
	}

	// 根据主键删除用户
	@Override
	public int deleteByPrimaryKey(Long userId) {
		// TODO Auto-generated method stub
		return userMapper.deleteByPrimaryKey(userId);
	}

	// 根据主键查询user
	@Override
	public User selectByPrimaryKey(Long userId) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(userId);
	}

	// 修改用户密码
	@Override
	public int updateUserSelective(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateByPrimaryKeySelective(user);
	}

	// 根据已填信息查询匹配的user
	@Override
	public User selectSelective(User record) {
		// TODO Auto-generated method stub
		return userMapper.selectSelective(record);
	}

	@Override
	public User selectByUserName(String uName) {
		// TODO Auto-generated method stub
		 return userMapper.selectByUserName(uName);
	}

	@Override
	public List<User> sortByDuration() {
		return userMapper.sortByDuration();
	}

	@Override
	public int modifyCredit(Integer consume, Long uId) {
		return userMapper.updateCredit(String.valueOf(consume), String.valueOf(uId));
	}

}
