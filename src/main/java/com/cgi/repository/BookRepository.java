package com.cgi.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.cgi.model.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, Integer>{
	
	@Query("{author:?0}")
	List<Book> getBooksByAuthor(String author);
	
	Book findByTitle(String title);
	
	@Query("{price:{$gt?0}}")
	List<Book> getBooksByPriceGt(double price);
	
	
}
