package com.zwc.Boke.sql;

import org.apache.ibatis.jdbc.SQL;

import com.zwc.Boke.pojo.User;



public class UserSqlProvider {
	public String insert(final User user){
	  return new SQL(){
		  {
		  	INSERT_INTO("user");
		  	if (user.getUsername()!=null) {
				VALUES("username", "#{username}");
			}	
		  	if (user.getPassword()!=null) {
				VALUES("password", "#{password}");
			}
		  }
		}.toString();
	}
	
	public String update(final User user){
		return new SQL(){
			{
				UPDATE("user");
				if (user.getUsername()!=null) {
					SET("username = #{username}");
				}
				if (user.getPassword()!=null) {
					SET("password = #{password}");
				}
				WHERE("id = #{id}");
			}
		}.toString();
	}
}
