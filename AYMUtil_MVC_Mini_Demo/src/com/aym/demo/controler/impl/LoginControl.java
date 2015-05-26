package com.aym.demo.controler.impl;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import aym.util.mvc.mini.IMVCInvokedProcessCallBack.MVCInvokedProcessSimpleCallBack;
import aym.util.mvc.mini.MVCUtil;

import com.aym.demo.controler.ILoginControl;
import com.aym.demo.entity.User;
import com.aym.demo.exception.HttpException;
import com.aym.demo.exception.UserNameCheckException;

/**
 * 
 */
public class LoginControl implements ILoginControl {

	@Override
	public User login(String name, String pwd, int tag,
			MVCInvokedProcessSimpleCallBack callback) throws HttpException,
			UserNameCheckException {
		// 检测用户名不能为admin,否则抛异常
		if ("admin".equals(name)) {
			throw new UserNameCheckException("用户名不能为admin");
		}
		// 伪造网络访问
		// 实例化User对象
		User user = new User();
		try {
			// 新建一个URL对象
			URL url = new URL("http://www.baidu.com");
			// 打开一个HttpURLConnection连接
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			// 设置连接超时时间
			con.setConnectTimeout(5 * 1000);
			// 设置读取时间
			con.setReadTimeout(5 * 1000);
			// 开始连接
			con.connect();
			// 判断请求是否成功
			if (con.getResponseCode() == 200) {
				// 请求成功，给构造的User对象赋值
				user.setUserName(name);
				user.setUserPwd(pwd);
			}
		} catch (MalformedURLException e) {
			throw new HttpException(e);
		} catch (IOException e) {
			throw new HttpException(e);
		}
		// 在这里不要将Context信息传入 如果需要Context信息调用 前提是需要在appliction里初始化
		MVCUtil.getAppContext();
		return user;
	}

	@Override
	public boolean loginOut() {
		return true;
	}

}
