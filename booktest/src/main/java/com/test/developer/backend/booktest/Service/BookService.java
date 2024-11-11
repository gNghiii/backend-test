package com.test.developer.backend.booktest.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.developer.backend.booktest.Model.Book;
import com.test.developer.backend.booktest.Repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	// Save a new book to the database
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}

	// Retrieve a book by its ID
	public Optional<Book> getBookById(Long id) {
		return bookRepository.findById(id);
	}

	// Retrieve all books from the database
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	// Update an existing book's details
	public Book updateBook(Long id, Book bookDetails) {
		Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
		book.setTitle(bookDetails.getTitle());
		book.setAuthor(bookDetails.getAuthor());
		book.setPublishedDate(bookDetails.getPublishedDate());
		book.setIsbn(bookDetails.getIsbn());
		book.setPrice(bookDetails.getPrice());
		return bookRepository.save(book);
	}

	 // Delete a book by its ID
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);

	}
}
