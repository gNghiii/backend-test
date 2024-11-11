package com.test.developer.backend.booktest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.developer.backend.booktest.Model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
