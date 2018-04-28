/**
 * Copyright (2018, ) Hebei Turing CO., LTD.
 */
package com.hbturing.eteacher.servicefrk.models;

import com.hbturing.eteacher.servicefrk.AbstractModel;

/**
 * @author wuheng(@hbturing.com)
 * @date   2018年4月12日
 * @desc   
 */
public class ExampleModel implements AbstractModel {

	protected String url;
	
	protected String name;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
