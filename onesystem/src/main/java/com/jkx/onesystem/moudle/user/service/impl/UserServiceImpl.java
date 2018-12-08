package com.jkx.onesystem.moudle.user.service.impl;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jkx.onesystem.moudle.user.bean.QueryCheckCodeReq;
import com.jkx.onesystem.moudle.user.bean.QueryCheckCodeRes;
import com.jkx.onesystem.moudle.user.service.UserService;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

	private static Logger logger = Logger.getLogger(UserService.class);

	@Autowired
	private HttpSession session;

	@Override
	public QueryCheckCodeRes getCheckCode(QueryCheckCodeReq req) {
		logger.info("-----------获取验证码-----------");

		// 验证码
		String code = null;
		// 是否存活（true:无需生成，false需要重新生成）
		boolean isActive = false;
		// session中验证码属性名称和值
		String sessionCheckCodeName = session.getId() + "-" + req.getPhoneNumber();
		String sessionCheckCodeValue = null;
		if (session.getAttribute(sessionCheckCodeName) != null) {
			sessionCheckCodeValue = session.getAttribute(sessionCheckCodeName).toString();
		}
		if (sessionCheckCodeValue != null) {
			String[] strArr = sessionCheckCodeValue.split("-");
			String sessionCheckCode = strArr[0];
			long createTime = Long.parseLong(strArr[1]);
			long nowTime = new Date().getTime();
			long timeDifference = (nowTime - createTime) / 1000;
			if (timeDifference < 60) {
				// session中存在且未过期的验证码可以直接返回
				code = sessionCheckCode;
				isActive = true;
			}
		}

		// 其他情况（session中不存在、session中存在但已经过期、用户换手机号获取验证码）均需要重新生成
		if (!isActive) {
			code = RandomStringUtils.randomNumeric(6);
			long createTime = new Date().getTime();
			session.setAttribute(sessionCheckCodeName, code + "-" + createTime);
		}
		QueryCheckCodeRes res = new QueryCheckCodeRes();
		res.setCode(code);
		return res;
	}

}
