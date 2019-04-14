package com.shop.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.service.AddressService;
@RequestMapping(value="/address")
@Controller
public class AddressController {
	@Resource(name="addressServiceImpl")
	private AddressService addressService;
	
	/**
	 * 查询所有省份
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectProvince",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public List<String> selectProvince() throws Exception{
		return addressService.selectAllProvinces();
	}
	
	/**
	 * 根据省份查询城市
	 * @param province
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectCity",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public List<String> selectCity(@RequestParam String province) throws Exception{
		return addressService.selectCityByProvince(province);
	}
	
	/**
	 * 根据城市查询区县
	 * @param city
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectArea",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public List<String> selectArea(@RequestParam String city) throws Exception{
		return addressService.selectAreaByCity(city);
	}
}
