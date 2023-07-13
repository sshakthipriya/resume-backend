package org.hackathon;

import lombok.extern.slf4j.Slf4j;
import org.hackathon.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@Slf4j
public class NotificationServiceApplication {
    @Autowired
    private EmailService emailService;
    @Autowired
    private Email email;
    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApplication.class, args);
    }

    @KafkaListener(topics = "notificationTopic")
    public void handleNotification(ReservationConfirmationMsg reservationConfirmationMsg){
        //send out mail here now

        String status = emailService.sendSimpleMail( email.builder()
                .recipient(reservationConfirmationMsg.getBorrowerMail())
                .msgBody("Congratulations you have successfully reserved the book from" + reservationConfirmationMsg.getStartDate().toString().substring(0,10)
                +"to" + reservationConfirmationMsg.getDueByDate().toString().substring(0,10)).subject("Successfully Reserved the book!!!").build());
        log.info(status);
    }

}
