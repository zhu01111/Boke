package com.zwc.Boke.dao;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import com.zwc.Boke.pojo.User;
import com.zwc.Boke.sql.UserSqlProvider;

@Mapper
public interface UserDao extends com.zwc.Boke.dao.Mapper<User, String, Integer>{
	
	@UpdateProvider(method="update",type=UserSqlProvider.class)
	int update(User user);
}
