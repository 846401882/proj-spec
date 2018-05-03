/**
 * Copyright (2018, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.isdream.springcloud.handlers;

import com.github.isdream.springcloud.core.annotation.BeanDefinition;
import com.github.isdream.springcloud.core.spi.HttpBodyHandler;

/**
 * @author wuheng(@otcaix.iscas.ac.cn)
 * @since   2018/5/3
 * 
 */ 
public class UserHandler extends HttpBodyHandler {

	@BeanDefinition(names= {"user"})
	public Object handleUser(User user) {
		return user;
	}
	
	@Override
	public String getOperation() {
		return "user";
	}

}
