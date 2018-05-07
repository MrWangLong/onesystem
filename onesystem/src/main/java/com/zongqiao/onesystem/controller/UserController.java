package com.zongqiao.onesystem.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.zongqiao.onesystem.domain.User;
import com.zongqiao.onesystem.service.UserService;
/**
 * 
 * 用户控制层
 * 
 * @author jkx
 *
 */
@Controller
@RequestMapping(value = "/user")
public class UserController
{
	private static Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	/**
	 * 
	 * @param session
	 * @param user:用户
	 * @param code:验证码
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/register.do")
	public String register(HttpSession session, User user, String code)
	{   String msg = "";
		// session中验证码属性名称和值
		String sessionCheckCodeName = session.getId() + "-" + user.getTelephone();
		String sessionCheckCodeValue = (String) session.getAttribute(sessionCheckCodeName);
		String sessionCheckCode = null;
		if (sessionCheckCodeValue != null)
		{
			String[] strArr = sessionCheckCodeValue.split("-");
			sessionCheckCode = strArr[0];
		}

		if (code.equals(sessionCheckCode))
		{
			// 传入的验证码和session中的一致
			if(userService.register(user))
			msg = "注册中";
		} else
		{
			// 传入的验证码和session中的不一致
			msg = "传入的验证码和session中的不一致!";
		}
		return msg;
	}

	// 获取验证码
	@ResponseBody
	@RequestMapping(value = "/getCheckCode.do")
	public String getCheckCode(HttpSession session, String phoneNumber)
	{
		logger.info("-----------获取验证码-----------");
		System.err.println(session.getId());
		// 验证码
		String code = null;
		// 是否存活（true:无需生成，false需要重新生成）
		boolean isActive = false;
		// session中验证码属性名称和值
		String sessionCheckCodeName = session.getId() + "-" + phoneNumber;
		String sessionCheckCodeValue = null;
		if (session.getAttribute(sessionCheckCodeName) != null)
		{
			sessionCheckCodeValue = session.getAttribute(sessionCheckCodeName).toString();
		}
		if (sessionCheckCodeValue != null)
		{
			String[] strArr = sessionCheckCodeValue.split("-");
			String sessionCheckCode = strArr[0];
			long createTime = Long.parseLong(strArr[1]);
			long nowTime = new Date().getTime();
			long timeDifference = (nowTime - createTime) / 1000;
			if (timeDifference < 60)
			{
				// session中存在且未过期的验证码可以直接返回
				code = sessionCheckCode;
				isActive = true;
			}
		}

		// 其他情况（session中不存在、session中存在但已经过期、用户换手机号获取验证码）均需要重新生成
		if (!isActive)
		{
			code = RandomStringUtils.randomNumeric(6);
			long createTime = new Date().getTime();
			session.setAttribute(sessionCheckCodeName, code + "-" + createTime);
		}

		return code;
	}

}
