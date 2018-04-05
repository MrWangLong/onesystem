package com.zongqiao.onesystem.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zongqiao.onesystem.domain.User;
import com.zongqiao.onesystem.util.VerificationCodeUtil;

/**
 * 
 * 用户控制层
 * @author jkx
 *
 */
@Controller
@RequestMapping(value="/user")
public class UserController {
	//注册
    @RequestMapping(value="/register.do")
	public void register(User user,String code){
    	System.out.println("user:" + user + "<-->code" + code);
	}
    //获取验证码
    @ResponseBody
    @RequestMapping(value="/getCheckCode.do")
    public String getCheckCode(HttpServletRequest request,String phoneNumber){
    	System.out.println("phoneNumber->" + phoneNumber);
    	HttpSession session = request.getSession();
    	//初始化返回值
    	String code = "";
        //获取session中：sessionId、手机号、验证码
    	String sessionId = session.getId();
    	System.out.println("sessionId->" + sessionId);
    	String sessionCode = sessionId + "-" + phoneNumber;
    	System.out.println("sessionCode->" + sessionCode);
    	System.out.println("session-code->" + session.getAttribute(sessionCode));
        code = VerificationCodeUtil.getInstance().getVerificationCode();
        session.setAttribute(sessionCode, sessionId + "-" + phoneNumber + "-" + code);
        System.out.println(code);
        System.out.println("放在session中的验证码->" + session.getAttribute(sessionCode));
    	return code;
    }
	
	
}
