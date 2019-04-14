package com.time.dao;

import org.springframework.stereotype.Repository;

import com.time.entity.Role;

@Repository("roleDao")
public interface RoleMapper {
    int deleteByPrimaryKey(Integer rType);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer rType);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}