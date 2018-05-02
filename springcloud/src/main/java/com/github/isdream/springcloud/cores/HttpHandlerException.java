/**
 * Copyrigt (2018, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.isdream.springcloud.cores;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since  2018年4月28日
 * 
 */
public class HttpHandlerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9056743329986575387L;
	
	
	protected final int status;

	public HttpHandlerException(int status, String message, Throwable cause) {
		super(message, cause);
		this.status = status;
	}


	public HttpHandlerException(int status, String message) {
		super(message);
		this.status = status;
	}


	public int getStatus() {
		return status;
	}

}
