/**
 * Copyright (2018, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.isdream.springcloud.cores;

import java.util.Properties;

import org.springframework.stereotype.Component;

import com.github.isdream.springcloud.cores.spi.HttpBodyHandler;

/**
 * @author wuheng(@otcaix.iscas.ac.cn)
 * @since   2018/4/28
 */
@Component
public class HttpHandlerConfigure {

	protected Properties handlers = new Properties();

	public void addHandler(String kind, Class<?> clazz) {
		handlers.put(kind, clazz);
	}

	public HttpBodyHandler geHandler(String kind) throws Exception {
		return (HttpBodyHandler) ((Class<?>) 
				handlers.get(kind)).newInstance();
	}


}
