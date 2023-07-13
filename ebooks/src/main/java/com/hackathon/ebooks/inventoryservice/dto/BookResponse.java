package com.hackathon.ebooks.inventoryservice.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Builder
public class BookResponse {

    private Long bookId;

    private String bookName;

    private String authorFirstName;

    private String authorLastName;

    private Long ownerId;

    private Long borrowerId;

    private boolean available;

    private Date lendingDate;

    private Date returnDate;

    private String ownerName;

    private String borrowerName;
}
