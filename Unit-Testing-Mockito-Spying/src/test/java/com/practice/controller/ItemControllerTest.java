package com.practice.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.practice.Business.ItemBusinessService;
import com.practice.model.Item;

@ExtendWith(value = SpringExtension.class )
@WebMvcTest(controllers = ItemController.class)
public class ItemControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ItemBusinessService itemBusinessService;

	@Test
	public void dummyItem_basic() throws Exception {

		RequestBuilder request = MockMvcRequestBuilders
				.get("/dummy-item")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{\"id\":1,\"name\":\"Banana\",\"price\":40,\"quantity\":12}"))  //string , json
				.andReturn();
	}
	
	@Test
	public void itemFromBusinessService_basic() throws Exception {
		when(itemBusinessService.retreiveHardcodedItem()).thenReturn(new Item(1,"Apple",75,10));

		RequestBuilder request = MockMvcRequestBuilders
				.get("/item-from-business-service")
				.accept(MediaType.APPLICATION_JSON);
		
	MvcResult result = mockMvc.perform(request)
			.andExpect(status().isOk())
			.andExpect(content().json("{id:1,name:Apple,price:75}"))  //string , json
			.andReturn();
	}
	
	@Test
	public void retrieveAllItems_basic() throws Exception {
		when(itemBusinessService.retriveAllData()).thenReturn(
				Arrays.asList(new Item(4,"Grapes",45,1),
						      new Item(3,"Orange",50,6))
				);
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/all-item-from-database")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{id:4,name:Grapes,price:45,quantity:1},{id:3,name:Orange,price:50,quantity:6}]"))
				.andReturn();		
	}
}
