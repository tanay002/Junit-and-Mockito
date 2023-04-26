 package com.practice.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.practice.Business.ItemBusinessService;
import com.practice.Business.SomeBusinessImpl;
import com.practice.data.ItemRepository;
import com.practice.data.SomeDataService;
import com.practice.model.Item;

@ExtendWith(MockitoExtension.class)
 class ItemBusinessMockTest {

	@InjectMocks
	 ItemBusinessService itemBusinessService;	
	
	@Mock
	ItemRepository itemRepository;
	
	@Test
	void getAllItemsData_basic() {
		when(itemRepository.findAll()).thenReturn(
			Arrays.asList(new Item(4,"Grapes",45,1),
				      new Item(3,"Orange",50,6))
		);
	List<Item> items= itemBusinessService.retriveAllData();
	assertEquals(45, items.get(0).getValue());
	assertEquals(300, items.get(1).getValue());
	}
}
