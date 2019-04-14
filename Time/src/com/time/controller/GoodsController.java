package com.time.controller;

import java.io.IOException;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.time.entity.Goods;
import com.time.entity.GoodsType;
import com.time.entity.Manager;
import com.time.service.GoodsService;
import com.time.service.ManagerService;
import com.time.util.DateUtil;
import com.time.util.FileUpload;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/goods")
@Controller
public class GoodsController extends BaseController {
	@Resource(name = "goodsServiceImpl")
	private GoodsService goodsServiceImpl;
	@Resource(name = "managerServiceImpl")
	private ManagerService managerServiceImpl;

	/**
	 * 查询商品。可以查询全部，按类别分类，按商品名称模糊查询，商品编号模糊查询（这些功能可以在查询时一起使用），都可分页
	 * 只有roleType是必填，管理员可以看到库存为0的商品，用户不可以
	 * 
	 * @param roleType
	 * @param goodsType
	 * @param desc
	 *            提示字段（模糊查询）
	 * @param goodsNum
	 * @param pageNum
	 * @param pageTotal
	 * @return
	 */
	@RequestMapping(value = "/goodsList", method = RequestMethod.POST)
	@ResponseBody
	public List<Goods> goodsList(@RequestParam(name = "roleType", required = true) Integer roleType,
			@RequestParam(name = "goodsType", required = false) Integer goodsType,
			@RequestParam(name = "desc", required = false) String desc,
			@RequestParam(name = "goodsNum", required = false) String goodsNum,
			@RequestParam(name = "pageNum", required = false) Integer pageNum,
			@RequestParam(name = "pageTotal", required = false) Integer pageTotal) {
		return goodsServiceImpl.showGoods(roleType, goodsType, desc, goodsNum, pageNum, pageTotal);
	}
	
	/**
	 * 获取所有商品类型
	 * 
	 * @return
	 */
	@RequestMapping(value = "/allGoodsType", method = RequestMethod.POST)
	@ResponseBody
	public List<GoodsType> getAllType(HttpServletRequest request){
		List<GoodsType> gTypes = goodsServiceImpl.getAllType();
		return gTypes;
	}

}
