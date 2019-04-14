package com.cakeshop.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cakeshop.entity.Address;
import com.cakeshop.entity.User;
import com.cakeshop.service.AddressService;

@RequestMapping("/address")
@Controller
public class AddressController {
	@Resource(name = "addressServiceImpl")
	private AddressService addressService;

	/**
	 * 查询一个用户的所有地址
	 * 
	 * @param userId
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/selectAddress", method = { RequestMethod.POST, RequestMethod.GET })
	public List<Address> selectAddress(HttpServletRequest request) throws Exception {
		User user = (User)request.getSession().getAttribute("user");
		List<Address> list = addressService.selectAddress(user.getUser_id());
		return list;
	}

	/**
	 * 根据地址id来删除单条地址
	 * 
	 * @param addressId
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteAddress", method = { RequestMethod.POST, RequestMethod.GET })
	public void deleteAddress(@RequestParam String addressId, HttpServletResponse response) throws Exception {
		addressService.deleteAddess(addressId);
		response.sendRedirect("http://localhost:8080/cakeshop/address.jsp");
	}

	/**
	 * 新增地址
	 * 
	 * @param address
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/insertAddress", method = RequestMethod.POST)
	public int insertAddress(@RequestBody Address address,HttpServletRequest request) throws Exception {
		User user = (User)request.getSession().getAttribute("user");
		address.setUser_id(user.getUser_id());
		return addressService.insertAddess(address);

	}

	/**
	 * 更新地址信息
	 * 
	 * @param address
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/updateAddress", method = RequestMethod.POST)
	public int updateAddress(@RequestBody Address address, HttpServletResponse response) throws Exception {

		return addressService.updateAddress(address);
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/selectProvince", method = RequestMethod.POST)
	public List<String> selectProvince() throws Exception {

		return addressService.selectProvince();
	}
	
	/**
	 * @param area_parent_id
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/selectCity", method = RequestMethod.POST)
	public List<String> selectCity(@RequestParam String area_parent_id) throws Exception {

		return addressService.selectCtiy(area_parent_id);
	}
}
