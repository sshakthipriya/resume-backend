package com.hackathon.ebooks.inventoryservice.service;

import com.hackathon.ebooks.inventoryservice.dto.BookResponse;
import com.hackathon.ebooks.inventoryservice.model.Book;
import com.hackathon.ebooks.inventoryservice.model.User;
import com.hackathon.ebooks.inventoryservice.repository.BookRepository;
import org.hibernate.boot.model.internal.ListBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookInventoryService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private BookResponse bookResponse;

    public List<BookResponse> getBooksListByBookName(String bookName){
        List<Book> bookList= this.bookRepository.findByBookNameEquals(bookName);
        return this.getBookReponses(bookList);
    }

    public List<BookResponse> getBooksListByAuthorName(String authorFirstName){
        List<Book> bookList= this.bookRepository.findByAuthorNameEquals(authorFirstName);
        return this.getBookReponses(bookList);
    }

    public List<BookResponse> getBooksListByBookAndAuthorName(String bookName, String authorFirstName){
        List<Book> bookList= this.bookRepository.findByBookNameAndAuthorNameEquals(bookName,authorFirstName);
        return this.getBookReponses(bookList);
    }

    public List<BookResponse> getBooksListByEmail(String email){
        User user = this.userService.findUserByEmail(email);
        List<Book> bookList= this.bookRepository.findByBorrowerIdEquals(user.getUserId());
        return this.getBookReponses(bookList);
    }

    public List<BookResponse> getBookReponses(List<Book> bookList){
        List<BookResponse> bookResponses = new ArrayList<BookResponse>();
        for(Book book:bookList){
            String ownerName = this.userService.findUserById(book.getOwnerId());
            bookResponses.add(bookResponse.builder().bookId(book.getBookId())
                    .bookName(book.getBookName())
                    .authorFirstName(book.getAuthorFirstName())
                    .authorLastName(book.getAuthorLastName())
                    .ownerName(ownerName)
                    .available(book.isAvailable())
                    .lendingDate(book.getLendingDate())
                    .returnDate(book.getReturnDate())
                    .build());
        }
        return bookResponses;
    }
}
