package com.cgi.model;

import org.springframework.stereotype.Component;
//Classes are considered as candidates for auto detetcion when using 
//annotation based config and classpath scanning
//Component is used to mark Java class as a bean->stored in a IoC containwe
@Component
public class BookDto { 
//	Data transfer ovhjects
	private int id;
	
	private String title;
	private double price;
	private String author;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	

}
