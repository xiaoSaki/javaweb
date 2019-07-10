package com.Model;

import java.util.HashSet;
import java.util.Set;

public class Customer {
	private Integer id;
	private String name;
	private Set<Order> order = new HashSet<>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Order> getOrder() {
		return order;
	}
	public void setOrder(Set<Order> order) {
		this.order = order;
	}

	
	

}
