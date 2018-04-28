/**
 * Copyright (2018, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.isdream.springcloud.cores;

import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 * @author wuheng(@otcaix.iscas.ac.cn)
 * @since   2018/4/28
 */
public abstract class HttpBodyHandler {

	/**
	 * 
	 * @param object
	 * @return
	 * @throws Exception
	 */
	protected abstract Object doHandle(Map<String, Object> body) throws Exception;
	
	
	/**
	 * Format converter
	 * 
	 * Convert object to JSON
	 * 
	 * @param object
	 * @return
	 */
	protected HttpResponse postHandle(Object object) {
		return new HttpResponse(HttpConstants.HTTP_RESPONSE_STATUS_OK, object);
	}
	
	/**
	 * handle logic
	 * 
	 * @param body
	 * @return
	 * @throws Exception
	 */
	public String handle(Map<String, Object> body) throws Exception {
		return JSON.toJSONString(
				postHandle(doHandle(body)));
	}

}
