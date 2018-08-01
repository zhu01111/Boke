package com.zwc.Boke.pojo;

import java.io.Serializable;
import java.sql.Date;


import me.fishlord.common.utils.BaseJsonView;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonView;
@Component
public class User implements Serializable{
	
	public interface ListView extends BaseJsonView{}
	
	@JsonView({ListView.class})
    private Integer id;
	
	@JsonView({ListView.class})
    private String username;
	
	@JsonView({ListView.class})
    private String password;
    
    private Integer loginCount;
    
    private Date lastLoginTime;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

	public Integer getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
}