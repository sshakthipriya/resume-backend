package com.hackathon.ebooks.bookingservice.service;

import com.hackathon.ebooks.bookingservice.event.ReservationConfirmationMsg;
import com.hackathon.ebooks.bookingservice.model.Book;
import com.hackathon.ebooks.bookingservice.model.User;
import com.hackathon.ebooks.bookingservice.repository.BookRepository;
import com.hackathon.ebooks.bookingservice.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    private final KafkaTemplate<String,ReservationConfirmationMsg> kafkaTemplate;
    @Transactional(
	rollbackOn={SQLException.class, IOException.class})
    public void reserveBook(Long bookId,String userEmail){
        Book book = this.bookRepository.findByBookId(bookId);
        User user = this.userRepository.findUserByUserEmail(userEmail);
        book.setAvailable(false);
        book.setLendingDate(Date.valueOf(LocalDate.now()));
        book.setReturnDate(Date.valueOf(LocalDate.now().plusDays(7)));
        book.setBorrowerId(user.getUserId());
        bookRepository.save(book);
        kafkaTemplate.send("notificationTopic",new ReservationConfirmationMsg(book.getBookName(),book.getLendingDate(),book.getReturnDate(),userEmail));
    }
}
