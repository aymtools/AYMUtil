package com.aym.demo.controler;

import aym.util.mvc.mini.IMVCInvokedProcessCallBack.MVCInvokedProcessSimpleCallBack;

import com.aym.demo.entity.User;
import com.aym.demo.exception.HttpException;
import com.aym.demo.exception.UserNameCheckException;

/**
 * 
 */
public interface ILoginControl {

	/**
	 * 用户名登陆<br>
	 * 包含tag 和CallBack 则会异步运行 运行结束自动调用回调
	 * 
	 * @param name
	 * @param pwd
	 * @return
	 * @throws HttpException
	 *             网络请求异常
	 * @throws UserNameCheckException
	 *             用户名非法异常
	 */
	public abstract User login(String name, String pwd, int tag,
			MVCInvokedProcessSimpleCallBack callback) throws HttpException,
			UserNameCheckException;

	/**
	 * 登出系统<br>
	 * 无tag 和CallBack 则会在当前线程中运行
	 * 
	 * @return
	 * @author 2014年12月10日 下午3:16:38 / 安亚明
	 * @version v1.0
	 */
	public abstract boolean loginOut();
}
