package com.time.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.time.entity.ChangeLog;

@Repository("changeLogDao")
public interface ChangeLogMapper {
    int deleteByPrimaryKey(Long clId);

    int insert(ChangeLog record);

    int insertSelective(ChangeLog record);

    ChangeLog selectByPrimaryKey(Long clId);

    int updateByPrimaryKeySelective(ChangeLog record);

    int updateByPrimaryKey(ChangeLog record);

    //查询用户地址
    List<ChangeLog> selectByuId(@Param("uId")Long uId);
}