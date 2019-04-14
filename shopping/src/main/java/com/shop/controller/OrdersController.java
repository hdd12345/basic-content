package com.shop.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.entity.MyList;
import com.shop.entity.Orders;
import com.shop.entity.Orders_detail;
import com.shop.service.OrdersService;

@RequestMapping(value="/orders")
@Controller
public class OrdersController {
	@Resource(name="ordersServiceImpl")
	private OrdersService ordersService;
	
	/**
	 * 添加订单及订单明细（仅限单个订单单条订单明细）
	 * @param orders({
	"address_id": 1,
	"orders_detail_list": [{
		"goods_id": 5,
		"quantity": 2,
		"total_price": 3998
	}],
	"shop_id": 2,
	"user_id": 3
	})
	 * @param orders_detail
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/insertOneOrders",method=RequestMethod.POST)
	@ResponseBody
	public int insertOneOrders(@RequestBody Orders orders) throws Exception{
		return ordersService.insertOrders_detail(orders);
	}
	
	/**
	 * 根据用户id查询订单，按时间降序排序
	 * @param user_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectOrdersByUser_id",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public List<Orders> selectOrdersByUser_id(@RequestParam int user_id) throws Exception{
		return ordersService.selectOrdersByUser_id(user_id);
	}
	
	/**
	 * 通过店铺id查询订单，按时间降序排序（结果集包含订单明细）
	 * @param shop_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectOrdersByShop_id",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public List<Orders> selectOrdersByShop_id(@RequestParam int shop_id) throws Exception{
		return ordersService.selectOrdersByShop_id(shop_id);
	}
	
	/**
	 * 通过店铺id及订单状态查询订单，按时间升序排序
	 * @param shop_id
	 * @param orders_state
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectOrdersByState",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public List<Orders> selectOrdersByState(@RequestParam int shop_id,
			@RequestParam String orders_state) throws Exception{
		return ordersService.selectOrdersByState(shop_id, orders_state);
	}
	
	/**
	 * 修改订单状态
	 * @param state
	 * @param orders_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateOrdersState",method=RequestMethod.POST)
	@ResponseBody
	public int updateOrdersState(@RequestParam String state,
			@RequestParam int orders_id) throws Exception{
		return ordersService.updateOrdersState(state, orders_id);
	}
	
	/**
	 * 模糊查询订单
	 * @param key_word
	 * @param user_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectOrders",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public List<Orders> selectOrders(@RequestParam String key_word,
			@RequestParam int user_id) throws Exception{
		return ordersService.selectOrders(key_word, user_id);
	}
}
