package com.jkx.onesystem.moudle.user.service;

import com.jkx.onesystem.moudle.user.bean.QueryCheckCodeReq;
import com.jkx.onesystem.moudle.user.bean.QueryCheckCodeRes;

public interface UserService {
   QueryCheckCodeRes getCheckCode(QueryCheckCodeReq req);
}
