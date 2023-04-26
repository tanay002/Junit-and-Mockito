package com.practice.Business;

import org.springframework.stereotype.Component;

import com.practice.model.Item;

@Component
public class ItemBusinessService {

	public Item retreiveHardcodedItem() {
		return new Item(1,"Apple", 70, 5);
	}
}
