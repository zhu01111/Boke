package com.zwc.Boke.job;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.zwc.Boke.pojo.User;
import com.zwc.Boke.service.UserService;


@Component
//@EnableScheduling
public class PrintTimeTask {
	
	@Autowired
	private UserService service;
	
	@Scheduled(cron="*/5 * * * * ?")
	public void print(){
		List<User> users = service.list();
		System.out.println(users.size());
	}
}
