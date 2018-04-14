package com.zongqiao.onesystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zongqiao.onesystem.dao.UserMapper;
import com.zongqiao.onesystem.domain.User;
import com.zongqiao.onesystem.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
	private UserMapper userDao;

	@Override
	public boolean register(User user) {
		
		return userDao.insert(user) == 1?true:false;
	}
	
	
    
    
}
