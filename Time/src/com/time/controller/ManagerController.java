package com.time.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.time.entity.Goods;
import com.time.entity.Manager;
import com.time.service.GoodsService;
import com.time.service.ManagerService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/manager")
@Controller
public class ManagerController extends BaseController {
	@Resource(name = "managerServiceImpl")
	private ManagerService managerServiceImpl;
	@Resource(name = "goodsServiceImpl")
	private GoodsService goodsServiceImpl;

	// 上传文件存储目录
	private static final String UPLOAD_DIRECTORY = "upload";

	// 上传配置
	private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 400; // 40MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 500; // 50MB

	/**
	 * 上传已经录入好的商品信息表格，并解析其中商品信息后插入数据库
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/uploadGoods", method = RequestMethod.POST)
	@ResponseBody
	public int uploadGoods(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 检测是否为多媒体上传
		if (!ServletFileUpload.isMultipartContent(request)) {
			// 如果不是则停止
			PrintWriter writer = response.getWriter();
			writer.println("Error: 表单必须包含 enctype=multipart/form-data");
			writer.flush();
			return -1;
		}
		// 配置上传参数
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
		factory.setSizeThreshold(MEMORY_THRESHOLD);
		// 设置临时存储目录
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

		ServletFileUpload upload = new ServletFileUpload(factory);

		// 设置最大文件上传值
		upload.setFileSizeMax(MAX_FILE_SIZE);

		// 设置最大请求值 (包含文件和表单数据)
		upload.setSizeMax(MAX_REQUEST_SIZE);

		// 中文处理
		upload.setHeaderEncoding("UTF-8");

		// 构造临时路径来存储上传的文件
		String uploadPath = "D:" + File.separator + UPLOAD_DIRECTORY;

		// 如果目录不存在则创建
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		String filePath = "";
		try {
			// 解析请求的内容提取文件数据
			@SuppressWarnings("unchecked")
			List<FileItem> formItems = upload.parseRequest(request);

			if (formItems != null && formItems.size() > 0) {
				// 迭代表单数据
				for (FileItem item : formItems) {
					// 处理不在表单中的字段
					if (!item.isFormField()) {
						String fileName = new File(item.getName()).getName();
						// 防止文件重名
						filePath = uploadPath + File.separator + this.get32UUID() + "&" + fileName;
						File storeFile = new File(filePath);
						// 在控制台输出文件的上传路径
						System.out.println(filePath);
						// 保存文件到硬盘
						item.write(storeFile);
						request.setAttribute("message", "文件上传成功!");
					}
				}
			}
		} catch (Exception ex) {
			request.setAttribute("message", "错误信息: " + ex.getMessage());
		}
		// 读取上传的表格，并插入
		return goodsServiceImpl.addManyNewGoods(filePath);
	}

	/**
	 * 添加商品，单条添加
	 * 
	 * @param goods
	 * @return
	 */
	@RequestMapping(value = "/addGoods", method = RequestMethod.POST)
	@ResponseBody
	public int addGoods(@RequestBody Goods goods) {
		System.out.println(goods.getgName());
		return goodsServiceImpl.addNewGoods(goods);
		
	}

	/**
	 * 修改商品信息
	 * 
	 * @param gList
	 * @return
	 */
	@RequestMapping(value = "/modifyGoodsInfo", method = RequestMethod.POST)
	@ResponseBody
	public int modifyGoodsInfo(@RequestBody Goods goods) {
		if (goods == null)
			return 0;
		return goodsServiceImpl.modifyGoodsInfo(goods);
	}

	/**
	 * 下架商品，支持批量删除
	 * 
	 * @param gId
	 * @return
	 */
	@RequestMapping(value = "/soldOutGoods", method = RequestMethod.DELETE)
	@ResponseBody
	public int soldOutGoods(@RequestParam(name = "gId", required = true) Long[] gId) {
		if (gId.length < 1)
			return 0;
		return goodsServiceImpl.removeGoods(gId);
	}

	/**
	 * 管理员修改密码
	 * 
	 * @param manager
	 * @return
	 */
	@RequestMapping(value = "/modifyManagerPwd", method = RequestMethod.POST)
	@ResponseBody
	public int modifyManagerPwd(@RequestBody Manager manager) {
		if (manager == null)
			return 0;
		return managerServiceImpl.updateByPrimaryKeySelective(manager);
	}
}
