package com.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Attr;
import com.practice.Business.ItemBusinessService;
import com.practice.model.Item;

@RestController
public class ItemController {

	@Autowired
	private ItemBusinessService itemBusinessService;
	
	@GetMapping("/dummy-item")
	public Item getItem() {
		return new Item(1,"Banana",40,12);
	}
	
	@GetMapping("/item-from-business-service")
	public Item itemFromBusinessService() {
		Item item = itemBusinessService.retreiveHardcodedItem();
		
		return item;
	}
}
