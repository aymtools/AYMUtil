package com.aym.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 *  登录成功显示的Activity
 */
public class SuccessActivity extends Activity {

	/** 显示登录成功的信息 */
	private TextView mShowText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_success);
		mShowText = (TextView) findViewById(R.id.a_success_show_tv);
		// 通过Intent获取数据
		Intent intent = this.getIntent();
		if (intent != null) {
			String userName = intent.getStringExtra("userName");
			String userPwd = intent.getStringExtra("userPwd");
			mShowText.setText("登录成功！用户名：" + userName + "，登录密码为：" + userPwd);
		}
	}
}
