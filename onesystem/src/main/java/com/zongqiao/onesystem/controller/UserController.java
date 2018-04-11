package com.zongqiao.onesystem.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zongqiao.onesystem.domain.User;

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
	// 注册
	@RequestMapping(value = "/register.do")
	public void register(User user, String code)
	{
		System.out.println("user:" + user + "<-->code" + code);
	}

	// 获取验证码
	@ResponseBody
	@RequestMapping(value = "/getCheckCode.do")
	public String getCheckCode(HttpSession session, String phoneNumber)
	{
		//验证码
		String code = null;
		//是否存活（true:无需生成，false需要重新生成）
		boolean isActive = false;
		//session中验证码属性名称和值
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
