package com.hackathon.ebooks.inventoryservice.model;

import jakarta.persistence.*;
import lombok.*;


import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book")
@Entity
@Builder
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @Column(name = "bookName")
    private String bookName;

    @Column(name="authorFirstName")
    private String authorFirstName;

    @Column(name="authorLastName")
    private String authorLastName;

    @Column(name="ownerId")
    private Long ownerId;

    @Column(name="borrowerId")
    private Long borrowerId;

    @Column(name="available")
    private boolean available;

    @Column(name="lendingDate")
    private Date lendingDate;

    @Column(name="returnDate")
    private Date returnDate;


}
