package com.time.serviceImpl;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.time.dao.TimeLogMapper;
import com.time.dao.UserMapper;
import com.time.entity.TimeLog;
import com.time.entity.User;
import com.time.service.TimeLogService;
import com.time.util.DateUtil;

@Service("timeLogServiceImpl")
public class TimeLogServiceImpl implements TimeLogService {
	@Resource(name = "timeLogDao")
	private TimeLogMapper timeLogDao;
	@Resource(name = "userDao")
	private UserMapper userDao;

	/**
	 * 添加一条时间记录,同时应该更新user的duration
	 */
	@Override
	public int addTimeLog(TimeLog timeLog) {
		if(timeLogDao.insertSelective(timeLog) > 0){
			Long min = DateUtil.getMinuteSub(timeLog.getStart(), timeLog.getExpire());
			System.out.println("增加的时长: " + min);
			User user = new User(timeLog.getuId(), min);
			return userDao.updateByPrimaryKeySelective(user);
		}
		return 0;
	}

	/**
	 * 删除记录，支持批量
	 */
	@Override
	public int deleteTimeLog(Long[] tLogId) {
		return timeLogDao.deleteByPrimaryKeyArray(tLogId);
	}

	/**
	 * 查看历史记录，支持限定时间范围，支持分类（查看完成的和未完成的）
	 */
	@Override
	public List<TimeLog> showTimeLogs(Long uId, Integer achieve, String start, String end, String sort, Integer pageNum,
			Integer pageTotal) {
		String uIdStr = String.valueOf(uId);
		String achieveStr = null;
		String pageNumStr = null;
		String pageTotalStr = null;
		if (null != achieve) {
			achieveStr = String.valueOf(achieve);
		}
		if (null != pageNum && null != pageTotal) {
			pageNumStr = String.valueOf(pageTotal * (pageNum - 1));
			pageTotalStr = String.valueOf(pageTotal);
		}
		System.out.println(start + "\n" + end);
		return timeLogDao.selectTimeLog(uIdStr, achieveStr, start, end, sort, pageNumStr, pageTotalStr);
	}

}
