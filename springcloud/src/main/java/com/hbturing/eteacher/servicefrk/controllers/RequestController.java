/**
 * Copyright (2018, ) Hebei Turing CO., LTD.
 */
package com.hbturing.eteacher.servicefrk.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.hbturing.eteacher.servicefrk.AbstractHandler;
import com.hbturing.eteacher.servicefrk.AbstractModel;
import com.hbturing.eteacher.servicefrk.ResponseResult;
import com.hbturing.eteacher.servicefrk.configures.HandlersConfigure;
import com.hbturing.eteacher.servicefrk.configures.KindsConfigure;

/**
 * @author wuheng(@hbturing.com)
 * @date   2018年4月11日
 * @desc   代码{@code RequestController}用于把URL交给指定的Handler进行处理
 * 
 * URL支持两种一般表示方法为http://example.com/serviceName/methodName
 */
@RestController
public class RequestController <H extends AbstractHandler<AbstractModel>, M extends AbstractModel> {

	public final static String DEFAULT_KIND = "default";
	
	public final static String KEY_KIND = "kind";
	
	public final static String KEY_PARAMS = "params";
	
	public static String nullRequestBodyResult = JSON.toJSONString(
												 new ResponseResult(
													ResponseResult.STATUS_ERROR,
													"Request body is null."));
	
	public static String invalidRequestResult = JSON.toJSONString(
												new ResponseResult(
													ResponseResult.STATUS_ERROR,
													"Unsupport method, please check your URL."));
	
	@SuppressWarnings("rawtypes")
	@Autowired HandlersConfigure hc;
	
	@SuppressWarnings("rawtypes")
	@Autowired KindsConfigure kc;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/*")
	@ResponseBody
	public String vaildRequest(HttpServletRequest request, 
							   @RequestBody Map<String, Object> body) {
		try {
			String kind = getKind(request.getServletPath(), body);
			H handler = (H) hc.getHandler(kind);
			M instance = (M) kc.getInstance(kind);
			System.out.println(body.get(KEY_PARAMS));
			BeanUtils.populate(instance, 
					(Map<String, ? extends Object>) body.get(KEY_PARAMS));
			return JSON.toJSONString(handler.handle(instance));
		} catch (Exception ex) {
			ResponseResult result = new ResponseResult();
			result.setStatus(ResponseResult.STATUS_ERROR);
			result.setMessage(ex.getMessage());
			return JSON.toJSONString(result);
		}
	}
	
	@ExceptionHandler
	@ResponseBody
    public String nullRequestBodyException(Exception e){
        return nullRequestBodyResult;  
    }  
	
	@RequestMapping("/*/**")
	@ResponseBody
	public String invaildRequest(HttpServletRequest request) {
        return invalidRequestResult;    
	}

	protected String getKind(String servletPath, Map<String, Object> userParams) {
		try {
			if (servletPath.length() != 1) {
				return servletPath.substring(1);
			} else {
				return (String) userParams.getOrDefault(KEY_KIND, DEFAULT_KIND);
			}
		} catch (Exception ex) {
			return DEFAULT_KIND;
		}
	}
}
