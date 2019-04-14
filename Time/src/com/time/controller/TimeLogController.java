package com.time.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.time.entity.TimeLog;
import com.time.service.TimeLogService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/timeLog")
@Controller
public class TimeLogController extends BaseController{
	@Resource(name = "timeLogServiceImpl")
	private TimeLogService timeLogServiceImpl;

	/**
	 * 查看历史记录。可以设置时间段查询，可以查看是否达到要求的记录 可以按时间排序，desc（时间降序）或者asc（时间升序）
	 * 设置限制的时间，以SimpleDateFormat("yyyy-MM-dd HH:mm:ss");的形式发送字符串
	 * 
	 * @param uId
	 * @param achieve
	 * @param start
	 * @param end
	 * @param sort
	 * @param pageNum
	 * @param pageTotal
	 * @return
	 */
	@RequestMapping(value = "/showTimeLog", method = RequestMethod.POST)
	@ResponseBody
	public List<TimeLog> showTimeLog(@RequestParam(name = "uId", required = true) Long uId,
			@RequestParam(name = "achieve", required = false) Integer achieve,
			@RequestParam(name = "start", required = false) String start,
			@RequestParam(name = "end", required = false) String end,
			@RequestParam(name = "sort", required = false) String sort,
			@RequestParam(name = "pageNum", required = false) Integer pageNum,
			@RequestParam(name = "pageTotal", required = false) Integer pageTotal) {

		return timeLogServiceImpl.showTimeLogs(uId, achieve, start, end, sort, pageNum, pageTotal);
	}

	/**
	 * 批量删除TimeLog
	 * 
	 * @param tLogId
	 * @return
	 */
	@RequestMapping(value = "/deleteTimeLog", method = RequestMethod.DELETE)
	@ResponseBody
	public int deleteTimeLog(@RequestParam(name = "tLogId", required = true) Long[] tLogId) {
		System.out.println("deleteTimeLog");
		if (tLogId.length < 1)
			return 0;
		return timeLogServiceImpl.deleteTimeLog(tLogId);
	}
	
	
	/**
	 * 增加使用记录
	 * 
	 * @param timeLog
	 * @return
	 */
	@RequestMapping(value = "/addTimeLog", method = RequestMethod.POST)
	@ResponseBody
	public int addTimeLog(@RequestBody TimeLog timeLog) {
		if(timeLog == null)
			return 0;
		return timeLogServiceImpl.addTimeLog(timeLog);
	}
	
	/**
	 * 增加使用记录
	 * 
	 * @param timeLog
	 * @return
	 */
	@RequestMapping(value = "/addTimeLogParam", method = RequestMethod.POST)
	@ResponseBody
	public int addTimeLog(@RequestParam(name = "uId", required = true) Long uId) {
		TimeLog timeLog = new TimeLog(null,uId,new Date(),new Date(),1,new Date());
		if(timeLog == null)
			return 0;
		return timeLogServiceImpl.addTimeLog(timeLog);
	}
}
