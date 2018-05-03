/**
 * Copyrigt (2018, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.isdream.springcloud.handlers;


import org.springframework.stereotype.Component;

import com.github.isdream.springcloud.core.annotation.BeanDefinition;
import com.github.isdream.springcloud.core.spi.HttpBodyHandler;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since  2018年4月28日
 * 
 * <p>
 * The {@code UnkownHandler} class is a {@code HttpBodyHandler} implementation example
 */
@Component
public class UnknownHandler extends HttpBodyHandler {

	@BeanDefinition
	public Object handle() {
		return "This is a demo";
	}
	
	@Override
	public String getOperation() {
		return "unknown";
	}

}
