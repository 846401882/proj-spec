/**
 * Copyright (2018, ) Hebei Turing CO., LTD.
 */
package com.hbturing.eteacher.servicefrk;

/**
 * @author wuheng(@hbturing.com)
 * @date   2018年4月11日
 * @desc   
 */
public class ResponseResult {

	public static String STATUS_SUCCESS = "success";
	
	public static String STATUS_ERROR = "error";
	
	protected String status;
	
	protected String message;
	
	protected Object result;

	public ResponseResult() {
		super();
	}
	
	public ResponseResult(String status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
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
