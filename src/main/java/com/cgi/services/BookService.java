package com.cgi.services;

import java.util.List;

import com.cgi.model.Book;

public interface BookService {
	Book insertBooksDetails(Book book);
	List<Book> getAllBooksDetail();
	List<Book> getBookDetailByAuthor(String Author);
	Book getBookByTitle(String title);
	List<Book> getBookByPrice(double price);
}
