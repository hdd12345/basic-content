package com.time.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.time.util.LoginCodeUtil;
import com.time.util.QrCoreUtil;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/login")
@Controller
public class QRLoginController extends BaseController {

	private int id;

	/**
	 * 主页面，二维码页面
	 * 
	 * @return
	 */
	// @RequestMapping(value = "/index", method = RequestMethod.GET)
	// public ModelAndView index() {
	// ModelAndView mv = new ModelAndView();
	// // 生成一个随机数，到页面
	// String uuid = UUID.randomUUID().toString().replace("-", "");
	// mv.addObject("uuid", uuid);
	// mv.setViewName("/index");
	// return mv;
	// }
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	@ResponseBody
	public String index() {
		// ModelAndView mv = new ModelAndView();
		// 生成一个随机数，到页面
		String uuid = get32UUID();
		// mv.addObject("uuid", uuid);
		// mv.setViewName("/index");
		// 储存状态
		LoginCodeUtil.set(uuid, LoginCodeUtil.CODE_STATE_DEFAULT);
		return uuid;
	}

	/**
	 * 获取二维码,输出到前端
	 */
	@RequestMapping(value = "/code/{uuid}", method = RequestMethod.GET)
	public void code(@PathVariable("uuid") String uuid, HttpServletResponse response) {

		String content = LoginCodeUtil.BASE_CODE_CONTEXT + uuid;

		System.out.println("添加uuid时" + LoginCodeUtil.class);
		// 生成二维码
		BufferedImage imageCode = QrCoreUtil.getQrCode(content);
		// 输出到页面
		response.setContentType("image/png");
		try {
			OutputStream os = response.getOutputStream();
			ImageIO.write(imageCode, "png", os);
			os.flush();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 二维码被扫描
	 * 
	 * @param uuid
	 * @param login
	 * @return
	 */
	@RequestMapping(value = "/scan/{uuid}/{id}", method = RequestMethod.GET)
	public ModelAndView scan(@PathVariable("uuid") String uuid, @PathVariable("id") String id) {
		ModelAndView mv = new ModelAndView();

		int state = LoginCodeUtil.get(uuid);
		// invalid
		if (state == LoginCodeUtil.CODE_STATE_INVALID) {
			mv.addObject("state", state);
		}

		else {
			// scaned
			LoginCodeUtil.set(uuid, LoginCodeUtil.CODE_STATE_SCANED);
			mv.addObject("state", LoginCodeUtil.CODE_STATE_SCANED);
			mv.addObject("id", id);
		}

		// 手机转到确认登录页面
		mv.setViewName("/scan");
		return mv;
	}

	/**
	 * 轮询验证
	 * 
	 * @param uuid
	 * @return
	 */
	@RequestMapping(value = "/validate", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> validate(@RequestParam("uuid") String uuid) {
		Map<String, Object> map = new HashMap<String, Object>();

		long begin = System.currentTimeMillis();

		while (true) {
			long curr = System.currentTimeMillis();
			if (curr - begin > LoginCodeUtil.INVALID_TIME) {
				// over time
				LoginCodeUtil.remove(uuid);
				map.put("state", LoginCodeUtil.CODE_STATE_INVALID);
				System.out.println("超时！！！");
				System.out.println(" *** qr code invalid ***");
				break;
			}

			int state = LoginCodeUtil.get(uuid);
			// invalid
			if (state == LoginCodeUtil.CODE_STATE_INVALID) {
				System.out.println("验证uuid时" + LoginCodeUtil.class);
				System.out.println("无效！！！");
				map.put("state", LoginCodeUtil.CODE_STATE_INVALID);
				break;
			}

			// scaned
			else if (state == LoginCodeUtil.CODE_STATE_SCANED) {
				map.put("state", LoginCodeUtil.CODE_STATE_SCANED);
				map.put("msg", " code is scaned...");
				// 被扫之后的状态
				LoginCodeUtil.set(uuid, LoginCodeUtil.CODE_STATE_SCANED_AFTER);
				break;
			}

			// login
			else if (state == LoginCodeUtil.CODE_STATE_LOGIN) {
				map.put("state", LoginCodeUtil.CODE_STATE_LOGIN);
				map.put("msg", " login finish...");
				map.put("id", id);
				LoginCodeUtil.remove(uuid);
				break;
			}

			// cancel
			else if (state == LoginCodeUtil.CODE_STATE_CANCEL) {
				map.put("state", LoginCodeUtil.CODE_STATE_CANCEL);
				map.put("msg", " login cancel...");
				LoginCodeUtil.remove(uuid);
				break;
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}

		return map;
	}

	/**
	 * 执行登录
	 * 
	 * @param uuid
	 * @param typeStr
	 * @return
	 */
	@RequestMapping(value = "/do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> login(@RequestParam("uuid") String uuid, @RequestParam("type") String typeStr,
			@RequestParam("id") int uid) {
		Map<String, Object> map = new HashMap<String, Object>();
		int value = LoginCodeUtil.get(uuid);
		// invalid
		if (value == LoginCodeUtil.CODE_STATE_INVALID) {
			map.put("state", LoginCodeUtil.CODE_STATE_INVALID);
			return map;
		}
		int type = Integer.parseInt(typeStr);
		// login，登录成功之后在map中添加用户的id
		if (type == LoginCodeUtil.CODE_STATE_LOGIN) {
			LoginCodeUtil.set(uuid, LoginCodeUtil.CODE_STATE_LOGIN);
			map.put("state", LoginCodeUtil.CODE_STATE_LOGIN);
			id = uid;
		}
		// cancel
		else if (type == LoginCodeUtil.CODE_STATE_CANCEL) {
			LoginCodeUtil.set(uuid, LoginCodeUtil.CODE_STATE_CANCEL);
			map.put("state", LoginCodeUtil.CODE_STATE_CANCEL);
		}
		// ... other
		return map;
	}

}
