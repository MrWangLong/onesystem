package com.zongqiao.onesystem.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zongqiao.onesystem.domain.User;
import com.zongqiao.onesystem.message.provider.service.MessageSenderService;

import net.sf.json.JSONObject;

/**
 * 
 * 消息测试控制层
 * 
 * @author jkx
 *
 */
@Controller
@RequestMapping(value = "/mq")
public class RabbitMqController {

	@Autowired
	@Qualifier("messageSenderService")
	MessageSenderService messageSenderService;

	@ResponseBody
	@RequestMapping(value = "/rabbitmq.do")
	public String register(HttpSession session, User user, String code) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("Message", "系统向您的邮箱813776775发送了一个邮件，请查收！");
		messageSenderService.sendMessage("send_email_queue", JSONObject.fromObject(map).toString());
		return "RabbitMq is Running!";
	}

}
