package com.cakeshop.controller;

import java.util.List;
import java.util.ResourceBundle;

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

import com.cakeshop.entity.Orders;
import com.cakeshop.entity.OrdersInfo;
import com.cakeshop.entity.User;
import com.cakeshop.mapper.OrdersMapper;
import com.cakeshop.service.OrdersService;
import com.cakeshop.util.PaymentUtil;
@RequestMapping(value="/orders")
@Controller
public class OrdersController {
	
	@Resource(name="ordersServiceImpl")
	OrdersService ordersService;
	
	/**
	 * 获取用户订单（包含订单明细、商品信息）
	 * @param user_id
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/getOrders",method={RequestMethod.GET,RequestMethod.POST})
	public List<OrdersInfo> getOrders(String user_id) throws Exception{
		return ordersService.selectOrdersByUser_id(user_id);
	}
	
//	/**
//	 * 获取单条订单信息（包含订单明细、商品信息）
//	 * @param orders_id
//	 * @return
//	 * @throws Exception
//	 */
//	@ResponseBody
//	@RequestMapping(value="/getDetail",method={RequestMethod.GET,RequestMethod.POST})
//	public OrdersInfo getDetail(@RequestParam String orders_id) throws Exception{
//		return ordersService.selectOrdersByOrders_id(orders_id);
//	}
	
	/**
	 * 添加订单
	 * @param ids:购物车明细id（通过逗号分隔）
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/addOrders",method=RequestMethod.POST)
	public Orders addOrders(@RequestParam String ids,String address_id,String user_id,
			HttpServletRequest request,HttpServletResponse response) throws Exception{
		String[] cartitem_ids = ids.split(",");
		Orders orders = ordersService.insertOrders(cartitem_ids, user_id, address_id);
//		request.setAttribute("orders_id",orders.getOrders_id());
//		request.setAttribute("money",orders.getOrders_total_price());
//		request.getRequestDispatcher("../pay.jsp").forward(request,response);
		return orders;
	}
	
	/**
	 * 支付回调
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/callBack",method={RequestMethod.POST,RequestMethod.GET})
	public void callBack(HttpServletRequest request,HttpServletResponse response) throws Exception{
		// 获得回调所有数据
				String p1_MerId = request.getParameter("p1_MerId");
				String r0_Cmd = request.getParameter("r0_Cmd");
				String r1_Code = request.getParameter("r1_Code");
				String r2_TrxId = request.getParameter("r2_TrxId");
				String r3_Amt = request.getParameter("r3_Amt");
				String r4_Cur = request.getParameter("r4_Cur");
				String r5_Pid = request.getParameter("r5_Pid");
				String r6_Order = request.getParameter("r6_Order");
				String r7_Uid = request.getParameter("r7_Uid");
				String r8_MP = request.getParameter("r8_MP");
				String r9_BType = request.getParameter("r9_BType");
				String rb_BankId = request.getParameter("rb_BankId");
				String ro_BankOrderId = request.getParameter("ro_BankOrderId");
				String rp_PayDate = request.getParameter("rp_PayDate");
				String rq_CardNo = request.getParameter("rq_CardNo");
				String ru_Trxtime = request.getParameter("ru_Trxtime");
				// 身份校验 --- 判断是不是支付公司通知你
				String hmac = request.getParameter("hmac");
				String keyValue = ResourceBundle.getBundle("merchantInfo").getString(
						"keyValue");

				// 自己对上面数据进行加密 --- 比较支付公司发过来hamc
				boolean isValid = PaymentUtil.verifyCallback(hmac, p1_MerId, r0_Cmd,
						r1_Code, r2_TrxId, r3_Amt, r4_Cur, r5_Pid, r6_Order, r7_Uid,
						r8_MP, r9_BType, keyValue);
				ordersService.updateOrders(r6_Order);//修改订单
				if (isValid) {
					// 响应数据有效
					if (r9_BType.equals("1")) {
						// 浏览器重定向
						response.setContentType("text/html;charset=utf-8");
						response.getWriter().println("<h1>付款成功！等待商城进一步操作！等待收货...</h1>");
					} else if (r9_BType.equals("2")) {
						// 服务器点对点 --- 支付公司通知你
						System.out.println("付款成功！");
						// 修改订单状态 为已付款
						// 回复支付公司
						response.getWriter().print("success");
					}
				} else {
					// 数据无效
					System.out.println("数据被篡改！");
				}
		
	}
	
	/**
	 * 支付
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/pay",method={RequestMethod.POST,RequestMethod.GET})
	public void topay(HttpServletRequest request,HttpServletResponse response) throws Exception{
		// 获得 支付必须基本数据
				String orderid = request.getParameter("orderid");
				String money = request.getParameter("money");
				// 银行
				String pd_FrpId = request.getParameter("pd_FrpId");

				// 发给支付公司需要哪些数据
				String p0_Cmd = "Buy";
				String p1_MerId = ResourceBundle.getBundle("merchantInfo").getString(
						"p1_MerId");
				String p2_Order = orderid;
				String p3_Amt = money;
				String p4_Cur = "CNY";
				String p5_Pid = "";
				String p6_Pcat = "";
				String p7_Pdesc = "";
				// 支付成功回调地址 ---- 第三方支付公司会访问、用户访问
				// 第三方支付可以访问网址
				//String p8_Url = "http://192.168.40.5:8888/callback";
				String p8_Url = "http://localhost:8080/cakeshop/orders/callBack";
				String p9_SAF = "";
				String pa_MP = "";
				String pr_NeedResponse = "1";
				// 加密hmac 需要密钥
				String keyValue = ResourceBundle.getBundle("merchantInfo").getString(
						"keyValue");
				String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt,
						p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
						pd_FrpId, pr_NeedResponse, keyValue);
				// 生成url --- url?
				request.setAttribute("pd_FrpId", pd_FrpId);
				request.setAttribute("p0_Cmd", p0_Cmd);
				request.setAttribute("p1_MerId", p1_MerId);
				request.setAttribute("p2_Order", p2_Order);
				request.setAttribute("p3_Amt", p3_Amt);
				request.setAttribute("p4_Cur", p4_Cur);
				request.setAttribute("p5_Pid", p5_Pid);
				request.setAttribute("p6_Pcat", p6_Pcat);
				request.setAttribute("p7_Pdesc", p7_Pdesc);
				request.setAttribute("p8_Url", p8_Url);
				request.setAttribute("p9_SAF", p9_SAF);
				request.setAttribute("pa_MP", pa_MP);
				request.setAttribute("pr_NeedResponse", pr_NeedResponse);
				request.setAttribute("hmac", hmac);

				request.getRequestDispatcher("/confirm.jsp").forward(request, response);
	}
}
