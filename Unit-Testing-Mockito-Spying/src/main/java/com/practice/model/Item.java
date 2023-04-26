package com.practice.model;

public class Item {

	private int id;
	private String name;
	private int price;
	private int quanitity;
	public Item(int id, String name, int price, int quanitity) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quanitity = quanitity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuanitity() {
		return quanitity;
	}
	public void setQuanitity(int quanitity) {
		this.quanitity = quanitity;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + ", quanitity=" + quanitity + "]";
	}
	
	
}
