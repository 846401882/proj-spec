/**
 * Copyright (2018, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.isdream.springcloud.spi;

import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.github.isdream.springcloud.cores.HttpResponse;

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
		return new HttpResponse(HttpResponse.OK, object);
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
