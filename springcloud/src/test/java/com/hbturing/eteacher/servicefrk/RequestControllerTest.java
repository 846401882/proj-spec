/**
 * Copyright (2018, ) Hebei Turing CO., LTD.
 */
package com.hbturing.eteacher.servicefrk;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.alibaba.fastjson.JSON;
import com.hbturing.eteacher.servicefrk.models.ExampleModel;

/**
 * @author wuheng(@hbturing.com)
 * @date 2018年4月11日
 * @desc
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.hbturing.eteacher.servicefrk.controllers.RequestController.class)
@AutoConfigureMockMvc
public class RequestControllerTest {

	public final static String ROOT_PATH = "/";
	
	public final static String VALID_PATH = "/createExample";
	
	public final static String INVALID_PATH = "/abc/abc";
	
	@Autowired
	private MockMvc mvc;

	@Test
	public void testNullRequestBody() throws Exception {
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post(
							ROOT_PATH).accept(MediaType.APPLICATION_JSON);
		mvc.perform(builder)
				.andExpect(status().isOk())
				.andExpect(jsonPath("status").value("error"))
				.andExpect(jsonPath("message").value("Request body is null."));
	}
	
	@Test
	public void testInvalidRequestBody() throws Exception {
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post(
							INVALID_PATH).accept(MediaType.APPLICATION_JSON);
		mvc.perform(builder)
				.andExpect(status().isOk())
				.andExpect(jsonPath("status").value("error"))
				.andExpect(jsonPath("message").value("Unsupport method, please check your URL."));
	}
	
	@Test
	public void testValidRequestBody() throws Exception {
		ExampleModel model = new ExampleModel();
		model.setName("turing");
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post(
							VALID_PATH)
							.accept(MediaType.APPLICATION_JSON_UTF8)
							.contentType(MediaType.APPLICATION_JSON)
							.content(JSON.toJSONString(model));
		mvc.perform(builder)
				.andExpect(status().isOk())
				.andDo(print());
	}
}
