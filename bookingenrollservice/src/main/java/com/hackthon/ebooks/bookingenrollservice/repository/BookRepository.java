package com.hackthon.ebooks.bookingenrollservice.repository;


import com.hackthon.ebooks.bookingenrollservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {



}
