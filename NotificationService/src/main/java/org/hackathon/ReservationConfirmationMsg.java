package org.hackathon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationConfirmationMsg {
    private String bookName;
    private Date startDate;
    private Date dueByDate;
    private String borrowerMail;
}
