package com.aym.demo;

import android.app.Application;
import aym.util.log.Log;
import aym.util.mvc.mini.MVCUtil;

public class MVCApplication extends Application {
	@Override
	public void onCreate() {
		super.onCreate();
		Log.isShowLog(true);// 打开关闭日志的展示状态
		/*
		 * 将全局上下文放入 方便使用MVCUtil.getAppContext() 
		 */
		MVCUtil.init(this);
	}
}
