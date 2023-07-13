package com.hackathon.ebooks.bookingservice.repository;

import com.hackathon.ebooks.bookingservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
    Book findByBookId(Long id);
}
