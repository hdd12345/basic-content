package com.hdd.service;

import org.springframework.stereotype.Service;

import com.hdd.entity.User;

public interface UserService {
	public User findUser(int id) throws Exception;
}
