package com.time.service;

import java.util.Date;
import java.util.List;

import com.time.entity.TimeLog;

public interface TimeLogService {
	// 添加一条记录
	public int addTimeLog(TimeLog timeLog);

	// 删除记录，支持批量
	public int deleteTimeLog(Long[] tLogId);

	// 查看历史记录
	public List<TimeLog> showTimeLogs(Long uId, Integer achieve, String start, String end, String sort, Integer pageNum,
			Integer pageTotal);
}
