package com.adobe.dao;

import java.util.List;

import com.adobe.entity.Book;

public interface BookDao {
	
	List<Book> getBooks();
	
	void addBook(Book book);
	
	Book getBook(int id);
	
	void deleteBook(int id);
	
	void updateBook(int id, Book book);
	
	List<Book> getBooksByPrice(double price);
}
