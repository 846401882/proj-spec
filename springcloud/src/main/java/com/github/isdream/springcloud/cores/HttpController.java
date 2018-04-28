/**
 * Copyright (2018, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.isdream.springcloud.cores;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
public class HttpController {

	public final static Logger m_logger = Logger.getLogger(HttpController.class);
	
	public final static String UNSUPPORT_REQUEST_URL = "Unsupport request URL.";

	public final static String BODY_KIND = "kind";
	
	public final static String BODY_PARAMS = "params";
	
	@Autowired
	protected HandlerConfigure configure;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/*")
	@ResponseBody
	public String handleVaildHttpRequest(
							HttpServletRequest request, 
							@RequestBody Map<String, Object> body) throws Exception{
		m_logger.info("Begin to deal with " + request.getPathInfo());
		String responseBody = configure.geHandler(
				getKind(request, body)).handle(
						(Map<String, Object>) body.get(BODY_PARAMS));
		m_logger.info("Deal with " + request.getPathInfo() + " successfully");
		return responseBody;
	}
	
	@RequestMapping("/*/**")
	@ResponseBody
	public String handleInvalidHttpRequestURL(HttpServletRequest request) {
		m_logger.error("Unsupport request URL" + request.getPathInfo());
		return JSONUtils.toJSONString(
        		new HttpResponse(HttpResponse.FAILED, UNSUPPORT_REQUEST_URL));
	}
	
	@ExceptionHandler
	@ResponseBody
	public String handleInvalidHttpRequestException(HttpServletRequest request, Exception e) {
		m_logger.error("Fail to deal with " + request.getPathInfo() 
									+ ", the reason is: " + String.valueOf(e));
        return JSONUtils.toJSONString(
        		new HttpResponse(HttpResponse.FAILED, String.valueOf(e)));
	}
	
	
	/**************************************************
	 * 
	 **************************************************/
	private String getKind(HttpServletRequest request, 
							@RequestBody Map<String, Object> body) {
		try {
			return request.getPathInfo().substring(1);
		} catch (Exception e) {
			return (String) body.get(BODY_KIND);
		}
	}

}
