package com.jkx.onesystem.entity.dao;

import com.jkx.onesystem.entity.bean.User;

public interface UserDao {
	int deleteByPrimaryKey(Integer userId);

	int insert(User user);

	int insertSelective(User user);

	User selectByPrimaryKey(Integer userId);

	int updateByPrimaryKeySelective(User user);

	int updateByPrimaryKey(User user);
}