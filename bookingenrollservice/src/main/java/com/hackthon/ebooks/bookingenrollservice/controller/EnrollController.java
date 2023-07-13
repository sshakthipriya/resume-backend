package com.hackthon.ebooks.bookingenrollservice.controller;

import com.hackthon.ebooks.bookingenrollservice.repository.BookRepository;
import com.hackthon.ebooks.bookingenrollservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enroll")
@CrossOrigin(origins = "http://localhost:4200")
public class EnrollController
{
    @Autowired
    private BookService bookService;

    @PostMapping("/{bookName}/{authorFirstName}/{authorLastName}/{userEmail}")
    @ResponseStatus(HttpStatus.OK)
    public void enrollBook(@PathVariable String bookName ,
                           @PathVariable String authorFirstName,
                           @PathVariable String authorLastName,
                           @PathVariable String userEmail)
    {
        this.bookService.enrollBook(bookName,authorFirstName,authorLastName,userEmail);
    }
}
