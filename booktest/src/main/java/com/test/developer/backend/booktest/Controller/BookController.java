package com.test.developer.backend.booktest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.developer.backend.booktest.Model.Book;
import com.test.developer.backend.booktest.Service.BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/books")
public class BookController {
	@Autowired
	private BookService bookService;

	@PostMapping
	public Book createBook(@Valid @RequestBody Book book) {
		return bookService.saveBook(book);   // Create a new book
	}

	@GetMapping("/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable Long id) {
		return bookService.getBookById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());  // Retrieve a book by its ID
	}

	@GetMapping
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();  // Retrieve all books
	}

	@PutMapping("/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable Long id, @Valid @RequestBody Book bookDetails) {
		return ResponseEntity.ok(bookService.updateBook(id, bookDetails)); // Update an existing book's details
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
		bookService.deleteBook(id);
		return ResponseEntity.noContent().build();  // Delete a book by its ID
	}

}
