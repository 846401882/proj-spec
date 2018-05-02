/**
 * Copyright (2018, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.isdream.springcloud.cores;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.isdream.springcloud.utils.JSONUtils;

/**
 * @author wuheng(@otcaix.iscas.ac.cn)
 * @since   2018/4/28
 */
@RestController
@ComponentScan
public class HttpController {

	public final static Logger m_logger = Logger.getLogger(HttpController.class);
	
	@Autowired
	protected HttpHandlerConfigure configure;
	
	@RequestMapping("/*")
	@ResponseBody
	public String handleVaildHttpRequest(
							HttpServletRequest request, 
							@RequestBody Map<String, Object> body) throws Exception{
		m_logger.info("Begin to deal with " + request.getServletPath());
		String responseBody = configure.geHandler(getOperator(request, body)).handle(body);
		m_logger.info("Successfully deal with " + request.getServletPath());
		return responseBody;
	}
	
	@RequestMapping("/*/**")
	@ResponseBody
	public String handleInvalidHttpRequestURL(HttpServletRequest request) {
		m_logger.error("Fail to deal with " + request.getPathInfo() 
						+ " the reason is: " + HttpConstants.EXCEPTION_INVALID_REQUEST_URL);
		return JSONUtils.toJSONString(
        		new HttpResponse(HttpConstants.HTTP_RESPONSE_STATUS_FAILED
        				, HttpConstants.EXCEPTION_INVALID_REQUEST_URL));
	}
	
	@ExceptionHandler
	@ResponseBody
	public String handleInvalidHttpRequestException(HttpServletRequest request, Exception e) {
		m_logger.error("Fail to deal with " + request.getPathInfo() 
									+ ", the reason is: " + String.valueOf(e));
        return JSONUtils.toJSONString(
        		new HttpResponse(HttpConstants.HTTP_RESPONSE_STATUS_FAILED, String.valueOf(e)));
	}
	
	
	/**************************************************
	 * 
	 **************************************************/
	private String getOperator(HttpServletRequest request, 
							@RequestBody Map<String, Object> body) {
		try {
			return request.getServletPath().substring(1);
		} catch (Exception e) {
			return (String) body.get(HttpConstants.HTTP_REQUEST_PATH_INFO);
		}
	}

}
