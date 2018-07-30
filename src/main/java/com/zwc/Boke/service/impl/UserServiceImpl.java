package com.zwc.Boke.service.impl;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.zwc.Boke.dao.UserDao;
import com.zwc.Boke.pojo.User;
import com.zwc.Boke.service.UserService;
import com.zwc.Boke.util.RedisUtil;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	StringRedisTemplate sTemplate;
	
	RedisUtil redisUtil = new RedisUtil();
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> list() {
		List<User> users;
		if (redisUtil.exists("usersb")) {
			users = (List<User>) redisUtil.get("usersb");
		}else {
			users = userDao.list("user");
			redisUtil.set("usersb", users,100L);
		}
		return users;
	}

	@Override
	public User findById(Integer id) {
		User user;
		if (redisUtil.exists("user1"+id)) {
			user = (User) redisUtil.get("user1"+id);
		}else {
			user = userDao.findById("user",id);
			redisUtil.set("user1"+id, user,60L);
		}		
		return user;
	}

	@Override
	public int add(User user) {
		return userDao.insert(user);
	}

	@Override
	public int update(User user) {
		return userDao.update(user);
	}
	
}
