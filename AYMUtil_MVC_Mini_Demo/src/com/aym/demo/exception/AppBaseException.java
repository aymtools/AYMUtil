package com.aym.demo.exception;

/**
 * 所有app异常的总类
 * 
 */
public abstract class AppBaseException extends RuntimeException {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	public AppBaseException() {
		super();
	}

	public AppBaseException(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
	}

	public AppBaseException(String detailMessage) {
		super(detailMessage);
	}

	public AppBaseException(Throwable throwable) {
		super(throwable);
	}

}
