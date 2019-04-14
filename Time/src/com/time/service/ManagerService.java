package com.time.service;

import java.util.ArrayList;

import com.time.entity.Manager;

public interface ManagerService {


		   public Manager selectByPrimaryKey(Integer managerId);
		
			
		   public int updateByPrimaryKeySelective(Manager record);

		   public Manager selectSelective(Manager record);
		   
		   
		   
		}


