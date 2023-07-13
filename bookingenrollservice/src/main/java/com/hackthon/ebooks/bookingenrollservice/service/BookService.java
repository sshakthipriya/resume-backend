package com.hackthon.ebooks.bookingenrollservice.service;

import com.hackthon.ebooks.bookingenrollservice.model.Book;
import com.hackthon.ebooks.bookingenrollservice.model.User;
import com.hackthon.ebooks.bookingenrollservice.repository.BookRepository;
import com.hackthon.ebooks.bookingenrollservice.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;

@Service
public class BookService
{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Transactional(
	rollbackOn={SQLException.class, IOException.class},
	dontRollbackOn={IllegalStateException.class})
    public void enrollBook(String bookName,String authorFirstName,String authorLastName,String userEmail)
    {
        User user = this.userRepository.findUserByUserEmail(userEmail);
        Book book = new Book();
        book.setBookName(bookName);
        book.setAvailable(true);
        book.setAuthorFirstName(authorFirstName);
        book.setAuthorLastName(authorLastName);
        book.setBorrowerId(null);
        book.setLendingDate(null);
        book.setReturnDate(null);
        book.setOwnerId(user.getUserId());
        this.bookRepository.save(book);

    }
}
