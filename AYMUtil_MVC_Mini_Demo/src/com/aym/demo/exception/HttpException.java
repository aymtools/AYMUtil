package com.aym.demo.exception;

/**
 * 
 *  网络访问异常
 */
public class HttpException extends AppBaseException {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	public HttpException() {
		super();
	}

	public HttpException(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
	}

	public HttpException(String detailMessage) {
		super(detailMessage);
	}

	public HttpException(Throwable throwable) {
		super(throwable);
	}

}
