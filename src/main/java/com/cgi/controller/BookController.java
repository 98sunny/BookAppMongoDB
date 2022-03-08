package com.cgi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.exceptions.BookNotFoundException;
import com.cgi.model.Book;
import com.cgi.services.BookService;

@RestController
public class BookController {
	@Autowired
	private BookService service;
	

	@PostMapping("/save")
	public Object insertRecord(@RequestBody Book book) {
		Book bk = service.insertBooksDetails(book);
		if (bk != null) {
			return bk;
		}
		return "no data inserted";

	}

	@GetMapping("/list")
	public ResponseEntity<?> getBookList() {
		List<Book> allBookDetail = service.getAllBooksDetail();
		if (allBookDetail.isEmpty()) {
			return new ResponseEntity<String>("Book list is empty", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(allBookDetail, HttpStatus.FOUND);

	}

	@GetMapping("/getByAuthor/{authorName}")
	public ResponseEntity<?> getBookByAuthor(@PathVariable("authorName") String name) {
		List<Book> allBookDetail = service.getBookDetailByAuthor(name);
		if (allBookDetail.isEmpty()) {
			return new ResponseEntity<String>("Book not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(allBookDetail, HttpStatus.FOUND);

	}

	@GetMapping("/getByTitle/{title}")
	public ResponseEntity<?> getBookByTitle(@PathVariable("title") String title) throws BookNotFoundException {
		Book book = service.getBookByTitle(title);
		if (book != null) {
			return new ResponseEntity<>(book, HttpStatus.FOUND);
		}
		else {
			throw new BookNotFoundException("Boot with title"+title+" not found");
			}
//		return new ResponseEntity<String>("Book not found", HttpStatus.NOT_FOUND);

	}

}
