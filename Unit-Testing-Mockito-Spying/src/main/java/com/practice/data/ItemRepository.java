package com.practice.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.model.Item;

public interface ItemRepository extends JpaRepository<Item,Integer>{

}
