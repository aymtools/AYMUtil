package com.aym.demo.exception;

/**
 * 
 * 
 * 用户名非法异常
 */
public class UserNameCheckException extends AppBaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNameCheckException() {
		super();
	}

	public UserNameCheckException(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
	}

	public UserNameCheckException(String detailMessage) {
		super(detailMessage);
	}

	public UserNameCheckException(Throwable throwable) {
		super(throwable);
	}

}
