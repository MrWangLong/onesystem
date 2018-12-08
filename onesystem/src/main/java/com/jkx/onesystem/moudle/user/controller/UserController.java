package com.jkx.onesystem.moudle.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jkx.onesystem.moudle.user.bean.QueryCheckCodeReq;
import com.jkx.onesystem.moudle.user.bean.QueryCheckCodeRes;
import com.jkx.onesystem.moudle.user.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/getCheckCode.do")
	public QueryCheckCodeRes getCheckCode(QueryCheckCodeReq req) {
		return userService.getCheckCode(req);
	}
}
