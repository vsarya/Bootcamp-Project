package com.adobe.dao.mem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.adobe.dao.BookDao;
import com.adobe.entity.Book;

@Repository
public class BookDaoMemImpl implements BookDao {
	
	private static List<Book> books = new ArrayList<Book>();
	
	static {
		books.add(new Book(1, "First", 234.44));
		books.add(new Book(2, "Second", 5234.00));
		books.add(new Book(3, "Third", 632.22));
		books.add(new Book(4, "Fourth", 733.33));
		books.add(new Book(5, "Fifth", 100.00));
	}

	@Override
	public List<Book> getBooks() {
		return books;
	}

	@Override
	public void addBook(Book book) {
		books.add(book);
	}

	@Override
	public Book getBook(int id) {
		Book b = null;
		Iterator<Book> iter = books.iterator();
		while(iter.hasNext()) {
			b = iter.next();
			if(b.getId() == id) {
				return b;
			}
		}
		return null;
	}

	@Override
	public void deleteBook(int id) {
		System.out.println("Delete " + id);
	}

	@Override
	public void updateBook(int id, Book book) {
		System.out.println("Update " + id);
	}

	@Override
	public List<Book> getBooksByPrice(double price) {
		return books.subList(1, 3);
	}

}
