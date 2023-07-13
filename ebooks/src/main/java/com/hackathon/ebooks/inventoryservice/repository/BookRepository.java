package com.hackathon.ebooks.inventoryservice.repository;

import com.hackathon.ebooks.inventoryservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {
    List<Book> findByBookNameEquals(String bookName);

    List<Book> findByBorrowerIdEquals(Long id);

    @Query(value = "SELECT * FROM BOOK WHERE author_First_Name =?1 OR author_Last_Name = ?1",nativeQuery = true)
    List<Book> findByAuthorNameEquals(String authorFirstName);

    @Query(value = "SELECT * FROM BOOK WHERE book_name = ?1 and (author_First_Name =?2 OR author_Last_Name = ?2)",nativeQuery = true)
    List<Book> findByBookNameAndAuthorNameEquals(String bookName, String authorFirstName);


}
