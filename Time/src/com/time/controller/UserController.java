package com.time.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.time.entity.Address;
import com.time.entity.ChangeLog;
import com.time.entity.Goods;
import com.time.entity.User;
import com.time.service.ChangeService;
import com.time.service.GoodsService;
import com.time.service.UserService;
import com.time.serviceImpl.UserServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/user")
@Controller
public class UserController {
	@Resource(name = "changeServiceImpl")
	private ChangeService changeServiceImpl;
	@Resource(name = "userServiceImpl")
	private UserService userServiceImpl;
	@Resource(name = "goodsServiceImpl")
	private GoodsService goodsServiceImpl;

	/**
	 * 添加地址
	 * 
	 * @param address
	 * @return
	 */
	@RequestMapping(value = "/addAddress", method = RequestMethod.POST)
	@ResponseBody
	public int addAddress(@RequestBody Address address) {
		if (address == null)
			return 0;
		return changeServiceImpl.addAddress(address);
	}

	/**
	 * 删除地址
	 * 
	 * @param arId
	 * @return
	 */
	@RequestMapping(value = "/deleteAddress", method = RequestMethod.DELETE)
	@ResponseBody
	public int deleteAddress(@RequestParam(name = "arId", required = true) Long arId) {
		if (arId == null)
			return 0;
		return changeServiceImpl.deleteAddress(arId);

	}

	/**
	 * 修改地址
	 * 
	 * @param address
	 * @return
	 */
	@RequestMapping(value = "/updateAddress", method = RequestMethod.POST)
	@ResponseBody
	public int updateAddress(@RequestBody Address address) {
		if (address == null) {
			return 0;
		}
		return changeServiceImpl.updateAddress(address);
	}

	/**
	 * 查看地址
	 * 
	 * @param uId
	 * @return
	 */
	@RequestMapping(value = "/showAddress", method = RequestMethod.POST)
	@ResponseBody
	public List<Address> showAddress(@RequestParam(name = "uId", required = true) Long uId) {
		return changeServiceImpl.showAddress(uId);
	}

	/**
	 * 兑换奖品，插入兑换记录
	 * 
	 * @param changeLog
	 * @return
	 */
	@RequestMapping(value = "/change", method = RequestMethod.POST)
	@ResponseBody
	public int change(@RequestParam(name="uId", required=true) Long uId,
			@RequestParam(name="gId", required=true) Long gId,
			@RequestParam(name="adrId", required=true) Long adrId,
			@RequestParam(name="consume", required=true) Integer consume) {
		if(goodsServiceImpl.changeGoods(gId) == 1){
			ChangeLog changeLog = new ChangeLog(uId, consume, gId, adrId);
			userServiceImpl.modifyCredit(consume,uId);
			return changeServiceImpl.newChangeLog(changeLog);
		}
		return 0;
	}

	/**
	 * 查看兑换记录
	 * 
	 * @param uId
	 * @return
	 */
	@RequestMapping(value = "/showChangeLog", method = RequestMethod.POST)
	@ResponseBody
	public List<ChangeLog> showChangeLog(@RequestParam(name = "uId", required = true) Long uId) {
		return changeServiceImpl.showChangeLog(uId);
	}

	/**
	 * 修改密码
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/modifyPwd", method = RequestMethod.POST)
	@ResponseBody
	public int modifyPwd(@RequestBody User user, HttpServletRequest request) {
//		request.getSession().removeAttribute("user");
//		request.getSession().setAttribute("user",user);
//		System.out.println("改密码" + user.getuPwd());
		return userServiceImpl.updateUserSelective(user);
	}

	/**
	 * 时长排行前20
	 * 
	 * @return
	 */
	@RequestMapping(value = "/sort", method = RequestMethod.POST)
	@ResponseBody
	public List<User> sortDuration() {
		return userServiceImpl.sortByDuration();
	}
}
