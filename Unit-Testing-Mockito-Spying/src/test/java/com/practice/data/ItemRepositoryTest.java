package com.practice.data;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.practice.model.Item;

@DataJpaTest
class ItemRepositoryTest {

	@Autowired
	ItemRepository itemRepository;
	
	@Test
	void testFindAll() {
		List<Item> items= itemRepository.findAll();
      assertEquals(6, items.size());
	}

}
