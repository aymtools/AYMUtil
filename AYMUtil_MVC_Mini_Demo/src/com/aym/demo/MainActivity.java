package com.aym.demo;

import com.aym.demo.controler.ILoginControl;
import com.aym.demo.controler.impl.LoginControl;
import com.aym.demo.entity.User;
import com.aym.demo.exception.HttpException;
import com.aym.demo.exception.UserNameCheckException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import aym.util.mvc.mini.IMVCInvokedProcessCallBack.MVCInvokedProcessSimpleCallBack;
import aym.util.mvc.mini.MVCUtil;
import aym.util.mvc.mini.annotation.MVCResControler;

/**
 * 
 */
public class MainActivity extends Activity {

	/** 用户名输入Edit */
	private EditText mUserNameEdit;
	/** 用户密码输入Edit */
	private EditText mUserPwdEdit;
	/** 登录按钮 */
	private Button mLoginBtn;
	/** 登录control */
	@MVCResControler(LoginControl.class)
	private ILoginControl mLoginControl;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		MVCUtil.inject(this);// 注入
		mUserNameEdit = (EditText) findViewById(R.id.a_main_userName_et);
		mUserPwdEdit = (EditText) findViewById(R.id.a_main_userPwd_et);
		mLoginBtn = (Button) findViewById(R.id.a_main_login_btn);
		mLoginBtn.setOnClickListener(clickListener);
	}

	/**
	 * 登录按钮点击处理
	 */
	private OnClickListener clickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if (v.getId() == R.id.a_main_login_btn) {
				// 点击按钮，登录
				String userName = mUserNameEdit.getText().toString();
				String userPwd = mUserPwdEdit.getText().toString();
				if (TextUtils.isEmpty(userName)||TextUtils.isEmpty(userPwd)) {
					Toast.makeText(MainActivity.this, "用户名和密码不能为空",
							Toast.LENGTH_SHORT).show();
				} else {
					mLoginControl.login(userName, userPwd, 1, callback);
				}
			}
		}
	};
	/**
	 * 登录请求callback
	 */
	private MVCInvokedProcessSimpleCallBack callback = new MVCInvokedProcessSimpleCallBack() {

		@Override
		public void invoked(int tag, Object result) {
			// 访问网络连接成功，并提示信息
			User user = (User) result;
			Intent intent = new Intent();
			intent.putExtra("userName", user.getUserName());
			intent.putExtra("userPwd", user.getUserPwd());
			intent.setClass(MainActivity.this, SuccessActivity.class);
			startActivity(intent);
		}

		/**
		 * 错误异常
		 */
		public void error(int tag, Exception e) {
			if (e instanceof HttpException) {
				Toast.makeText(MainActivity.this, "HttpException异常",
						Toast.LENGTH_SHORT).show();
			} else if (e instanceof UserNameCheckException) {
				Toast.makeText(MainActivity.this,
						"UserNameCheckException异常,用户名不能为admin",
						Toast.LENGTH_SHORT).show();
			}
		};
	};
}
