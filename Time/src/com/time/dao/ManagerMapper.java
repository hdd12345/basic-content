package com.time.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.time.entity.Manager;

@Repository("managerDao")
public interface ManagerMapper {
    int deleteByPrimaryKey(Integer mId);

    int insert(Manager record);

    int insertSelective(Manager record);

    Manager selectByPrimaryKey(Integer mId);

    int updateByPrimaryKeySelective(Manager record);

    int updateByPrimaryKey(Manager record);
    
    int updateUserSelective(Manager record);
    
    Manager selectSelective(Manager record);
    
    List<Manager> selectLike(Manager record);
}