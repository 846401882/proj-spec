/**
 * Copyright (2018, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.isdream.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author wuheng(@otcaix.iscas.ac.cn)
 * @since   2018/4/28
 */
@SpringBootApplication
@ComponentScan
@EnableConfigurationProperties
public class ApplicationServer {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationServer.class, args);
	}
}