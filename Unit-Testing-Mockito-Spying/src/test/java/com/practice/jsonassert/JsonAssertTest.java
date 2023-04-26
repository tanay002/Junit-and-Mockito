package com.practice.jsonassert;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

class JsonAssertTest {
String actualResponse="{\"id\":1,\"name\":\"Banana\",\"price\":40,\"quanitity\":12}";
	@Test
	void jsonAssertStrictTrue() throws JSONException {
		String expectedResponse="{\"id\":1,\"name\":\"Banana\",\"price\":40}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, true); // check exact response without checking
		//space
	}
	
	@Test
	void jsonAssertStrictFalse() throws JSONException {
		String expectedResponse="{\"id\":1,\"name\":\"Banana\",\"price\":40}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
		//check key and value of json resolve , if value chnages in output ,it false the condition.
	}
	
	@Test
	public void jsonAssert_WithoutEscapeCharacters() throws JSONException {
		String expectedResponse = "{id:1,name:Banana,price:40}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
	}

}
