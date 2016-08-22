package com.adobe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adobe.dao.BookDao;
import com.adobe.entity.Book;

@Controller
public class BookController {

	@Autowired
	private BookDao bookDao;
	
	@RequestMapping(value="/books", method = RequestMethod.GET)
	public @ResponseBody List<Book> getBooks() {
		return bookDao.getBooks();
	}
	
	@RequestMapping(value="/books", method = RequestMethod.POST)
	public ResponseEntity<String> addBook(@RequestBody Book book) {
		bookDao.addBook(book);
		return new ResponseEntity<String>("Book " + book.getTitle() + " added", HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/books/{id}", method = RequestMethod.GET)
	public @ResponseBody Book getBook(@PathVariable("id") int id) {
		return bookDao.getBook(id);
	}
	
	@RequestMapping(value="/books/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateBook(@PathVariable("id") int id, @RequestBody Book book) {
		bookDao.updateBook(id, book);
		return new ResponseEntity<String>("Book " + book.getTitle() + " updated", HttpStatus.OK);
	}
	
	@RequestMapping(value="/books/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteBook(@PathVariable("id") int id) {
		bookDao.deleteBook(id);
		return new ResponseEntity<String>("Book " + id + " deleted", HttpStatus.OK);
	}
	
	@RequestMapping(value="/books/", method = RequestMethod.GET)
	public @ResponseBody List<Book> getBooksByPrice(@RequestParam("amt") double price) {
		return bookDao.getBooksByPrice(price);
	}
}
