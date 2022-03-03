package com.cda.pc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Computer {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String mark;
	private float price;
	private int stock;
	private String category;
	
	
	public Computer(String name, String mark, float price, int stock, String category) {
		super();
		this.name = name;
		this.mark = mark;
		this.price = price;
		this.stock = stock;
		this.category = category;
	}
	
	public Computer() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
}
