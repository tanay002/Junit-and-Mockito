package com.practice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ItemControllerIntegrationTesting {

	@Autowired
	TestRestTemplate testRestTemplate;
	
	@Test
	public void contextLoads() throws JSONException
	{
		String response=this.testRestTemplate.getForObject("/all-item-from-database", String.class);
		JSONAssert.assertEquals("[{id:2,name:Apple,price:110},{id:3,name:Orange,price:50}]", response,false);
	}
}
