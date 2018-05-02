/**
 * Copyright (2018, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.isdream.springcloud.cores.spi;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.alibaba.fastjson.JSON;
import com.github.isdream.springcloud.cores.HttpConstants;
import com.github.isdream.springcloud.cores.HttpController;
import com.github.isdream.springcloud.cores.HttpHandlerConfigure;
import com.github.isdream.springcloud.cores.HttpResponse;

/**
 * @author wuheng(@otcaix.iscas.ac.cn)
 * @since   2018/4/28
 */
public abstract class HttpBodyHandler implements CommandLineRunner {

	public final static Logger m_logger = Logger.getLogger(HttpController.class);
	
	/**********************************************************
	 * 
	 * 
	 * 
	 **********************************************************/
	
	@Autowired
	protected HttpHandlerConfigure configure;
	
	@Override
	public void run(String... args) throws Exception {
		configure.addHandler(getOperation(), getClass());
	}
	
	public abstract String getOperation();
	
	
	/**********************************************************
	 * 
	 * 
	 * 
	 **********************************************************/
	
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
