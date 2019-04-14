package com.time.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.time.entity.User;

@Repository("userDao")
public interface UserMapper {
	int deleteByPrimaryKey(Long uId);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Long uId);

	int updateByPrimaryKeySelective(User record);

	User selectSelective(User record);
	
	User selectByUserName(String uName);

	List<User> sortByDuration();

	int updateCredit(@Param("consume")String consume, @Param("uId")String uId);

}