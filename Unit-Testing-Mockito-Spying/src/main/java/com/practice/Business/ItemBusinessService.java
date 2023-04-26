package com.practice.Business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.practice.data.ItemRepository;
import com.practice.model.Item;

@Component
public class ItemBusinessService {

	@Autowired
	ItemRepository itemRepository;
	
	public Item retreiveHardcodedItem() {
		return new Item(1,"Apple", 70, 5);
	}
	
	public List<Item> retriveAllData()
	{
		return itemRepository.findAll();
	}
}
