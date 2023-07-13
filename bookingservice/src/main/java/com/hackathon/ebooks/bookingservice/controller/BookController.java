package com.hackathon.ebooks.bookingservice.controller;

import com.hackathon.ebooks.bookingservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/booking")

public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/{bookId}/{userEmail}")
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseStatus(HttpStatus.OK)
    public void reserveBook(@PathVariable Long bookId, @PathVariable String userEmail){
        this.bookService.reserveBook(bookId,userEmail);
    }
}
