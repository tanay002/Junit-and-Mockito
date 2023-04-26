package com.practice.Business;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
		List<Item> items=itemRepository.findAll();
		Comparator<Item> byPrice=(item1,item2)->item1.getPrice()-item2.getPrice();
		items=items.stream()
				.filter(itemss->itemss.getPrice()>40)
				.sorted(byPrice).collect(Collectors.toList());
		for(Item item:items)
		{
			item.setValue(item.getPrice()*item.getQuantity());
		}
		return items;
	}
}
