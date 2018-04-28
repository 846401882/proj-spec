/**
 * Copyright (2018, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.isdream.springcloud.cores;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.github.isdream.springcloud.spi.HttpBodyHandler;

/**
 * @author wuheng(@otcaix.iscas.ac.cn)
 * @since   2018/4/28
 */
@Component
public class HandlerConfigure implements CommandLineRunner {

	protected Properties handlers = new Properties();

	@Autowired
	protected ResourceLoader loader;

	@Override
	public void run(String... args) throws Exception {
		handlers.load(loader.getResource("classpath:handlers.properties").getInputStream());
	}

	public HttpBodyHandler geHandler(String kind) throws Exception {
		return (HttpBodyHandler) Class.forName(
				(String) handlers.get(kind)).newInstance();
	}


}
