package com.time.service;

import java.util.ArrayList;
import java.util.List;

import com.time.entity.User;

public interface UserService {

	   public int insert(User user) ;

	   public int deleteByPrimaryKey(Long userId) ;

	   public User selectByPrimaryKey(Long userId);
	
	   public int updateUserSelective(User user) ;

	   public User selectSelective(User record);
	   
	   public User selectByUserName(String uName);
	   
	   public List<User> sortByDuration();

	   public int modifyCredit(Integer consume, Long uId);
	}	


