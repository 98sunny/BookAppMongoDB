package com.cgi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.model.Book;
import com.cgi.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{
	@Autowired
	private BookRepository repository;

	@Override
	public Book insertBooksDetails(Book book) {
		// TODO Auto-generated method stub
		if(book.getTitle().isEmpty()||book.getTitle().length()<2)
		return null;
	
		return repository.save(book);
	}

	@Override
	public List<Book> getAllBooksDetail() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public List<Book> getBookDetailByAuthor(String author) {
		// TODO Auto-generated method stub
		return repository.getBooksByAuthor(author);
		
	}

	@Override
	public Book getBookByTitle(String title) {
		// TODO Auto-generated method stub
		return repository.findByTitle(title);
	}
	@Override
	public List<Book> getBookByPrice(double price){
		return repository.getBooksByPriceGt(price);
	}

}
