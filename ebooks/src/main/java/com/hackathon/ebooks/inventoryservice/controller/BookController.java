package com.hackathon.ebooks.inventoryservice.controller;

import com.hackathon.ebooks.inventoryservice.dto.BookResponse;
import com.hackathon.ebooks.inventoryservice.model.Book;
import com.hackathon.ebooks.inventoryservice.service.BookInventoryService;
import com.hackathon.ebooks.inventoryservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/inventory")
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {

    @Autowired
    private BookInventoryService bookInventoryService;

    @Autowired
    private UserService userService;

    @GetMapping("/book/{name}")
    public List<BookResponse> getBooksByBookName(@PathVariable String name)
    {
        List<BookResponse> bookList = bookInventoryService.getBooksListByBookName(name);
        return bookList;
    }

    @GetMapping("/author/{name}")
    public List<BookResponse> getBooksByAuthorName(@PathVariable String name)
    {
        List<BookResponse> bookList = bookInventoryService.getBooksListByAuthorName(name);
        return bookList;
    }

    @GetMapping("/{bname}/{aname}")
    public List<BookResponse> getBooksByBookAndAuthorName(@PathVariable String bname,@PathVariable String aname)
    {
        List<BookResponse> bookList = bookInventoryService.getBooksListByBookAndAuthorName(bname,aname);
        return bookList;
    }

    @GetMapping("/getmybooks/{email}")
    public List<BookResponse> getMyBooks(@PathVariable String email){
        List<BookResponse> bookList = bookInventoryService.getBooksListByEmail(email);
        return bookList;
    }

}
