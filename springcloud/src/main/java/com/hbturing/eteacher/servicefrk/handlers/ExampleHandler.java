/**
 * Copyright (2018, ) Hebei Turing CO., LTD.
 */
package com.hbturing.eteacher.servicefrk.handlers;

import java.util.HashMap;
import java.util.Map;

import com.hbturing.eteacher.servicefrk.AbstractHandler;
import com.hbturing.eteacher.servicefrk.models.ExampleModel;

/**
 * @author wuheng(@hbturing.com)
 * @date   2018年4月12日
 * @desc   
 */
public class ExampleHandler extends AbstractHandler<ExampleModel> {

	private static Map<String, String> map = new HashMap<String, String>();
	
	static {
		map.put("turing", "http://www.turing.com");
		map.put("ISCAS", "http://www.is.cas.cn");
	}
	
	@Override
	protected void preHandle(ExampleModel object) throws Exception {
		if (object.getName() == null) {
			throw new NullPointerException("Name is Null");
		}
	}

	@Override
	protected Object doHandle(ExampleModel object) throws Exception {
		if(!map.containsKey(object.getName())) {
			throw new Exception("Invalid example name");
		}
		object.setUrl(map.get(object.getName()));
		return object;
	}

}
