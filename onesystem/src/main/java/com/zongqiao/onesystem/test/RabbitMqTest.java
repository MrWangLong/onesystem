package com.zongqiao.onesystem.test;

import java.util.HashMap;
import java.util.Map;

/*import org.junit.Test;*/
import org.springframework.beans.factory.annotation.Autowired;

import com.zongqiao.onesystem.message.provider.service.MessageSenderService;

public class RabbitMqTest {

	@Autowired
	MessageSenderService messageSenderService;

	/*@Test*/
	public void test() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("phone", "1532440545");
		map.put("idNo", "342921199412053814");
		messageSenderService.sendMessage("zx_black_risk_key", map);
		
	}
}
