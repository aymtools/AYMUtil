package com.aym.demo.entity;

import java.io.Serializable;

/**
 * 
 * User实体类
 */
public class User implements Serializable {

	/** 序列号 */
	private static final long serialVersionUID = 1L;
	/** 用户名 */
	private String userName;
	/** 密码 */
	private String userPwd;

	/** 用户名 */
	public String getUserName() {
		return userName;
	}

	/** 用户名 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/** 密码 */
	public String getUserPwd() {
		return userPwd;
	}

	/** 密码 */
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
}
