/**
 * Copyright (2018, ) Hebei Turing CO., LTD.
 */
package com.hbturing.eteacher.servicefrk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author wuheng(@hbturing.com)
 * @date   2018年4月11日
 * @desc   
 */
@SpringBootApplication
@ComponentScan
@EnableConfigurationProperties
public class ApplicationServer {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationServer.class, args);
	}
}
