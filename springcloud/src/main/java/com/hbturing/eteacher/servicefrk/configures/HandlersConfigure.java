/**
 * Copyright (2018, ) Hebei Turing CO., LTD.
 */
package com.hbturing.eteacher.servicefrk.configures;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.hbturing.eteacher.servicefrk.AbstractHandler;
import com.hbturing.eteacher.servicefrk.AbstractModel;

/**
 * @author wuheng(@hbturing.com)
 * @date   2018年4月12日
 * @desc   
 */
@Component
public class HandlersConfigure <H extends AbstractHandler<AbstractModel>> implements CommandLineRunner {

	protected Properties handlers = new Properties();

	@Autowired
    protected ResourceLoader resourceLoader;
	
	@Override
	public void run(String... args) throws Exception {
		try {
			handlers.load(resourceLoader.getResource(
					"classpath:handlers.properties").getInputStream());
		} catch (Exception ex) {
			// ignore here
		}
	}

	/**
	 * 直接抛出异常 
	 * 
	 * @param kind
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public H getHandler(String kind) throws Exception {
		System.out.println(handlers.getProperty(kind));
		return  (H) Class.forName(
				handlers.getProperty(kind)).newInstance();
	}
}
