package com.time.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.time.entity.TimeLog;

@Repository("timeLogDao")
public interface TimeLogMapper {
	// 根据id数组批量删除
	int deleteByPrimaryKeyArray(@Param("array") Long[] tLogId);

	int insert(TimeLog record);

	int insertSelective(TimeLog record);

	TimeLog selectByPrimaryKey(Long tlId);

	int updateByPrimaryKeySelective(TimeLog record);

	int updateByPrimaryKey(TimeLog record);

	// 查询记录
	List<TimeLog> selectTimeLog(@Param("uId") String uId, @Param("achieve") String achieve,
			@Param("start") String start, @Param("end") String end, @Param("sort") String sort,
			@Param("pageNum") String pageNum, @Param("pageTotal") String pageTotal);

}