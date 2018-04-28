/**
 * Copyright (2018, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.isdream.springcloud.cores;

/**
 * @author wuheng(@otcaix.iscas.ac.cn)
 * @since   2018/4/28
 */
public class HttpResponse {

	protected int status;
	
	protected String message;
	
	protected Object result;
	
	public HttpResponse() {
		super();
	}
	
	public HttpResponse(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public HttpResponse(int status, Object result) {
		super();
		this.status = status;
		this.result = result;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

}
