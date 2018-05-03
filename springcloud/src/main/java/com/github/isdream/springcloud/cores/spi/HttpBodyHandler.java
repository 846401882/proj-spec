/**
 * Copyright (2018, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.isdream.springcloud.cores.spi;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.github.isdream.springcloud.cores.HttpController;
import com.github.isdream.springcloud.cores.HttpHandlerConfigure;

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
	
	
}
