/**
 * Copyright (2018, ) Hebei Turing CO., LTD.
 */
package com.hbturing.eteacher.servicefrk.configures;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.hbturing.eteacher.servicefrk.AbstractModel;

/**
 * @author wuheng(@hbturing.com)
 * @date   2018年4月12日
 * @desc   
 */
@Component
public class KindsConfigure <M extends AbstractModel> implements CommandLineRunner {

	protected Properties kinds = new Properties();

	@Autowired
    protected ResourceLoader resourceLoader;
	@Override
	public void run(String... args) throws Exception {
		try {
			kinds.load(resourceLoader.getResource(
					"classpath:/kinds.properties").getInputStream());
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
	public M getInstance(String kind) throws Exception {
		return (M) Class.forName(kinds.getProperty(kind)).newInstance();
	}
}
