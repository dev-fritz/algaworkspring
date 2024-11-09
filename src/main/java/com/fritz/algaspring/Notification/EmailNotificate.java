package com.fritz.algaspring.Notification;

import com.fritz.algaspring.Annotations.NofificationType;
import com.fritz.algaspring.Entities.Customer;
import com.fritz.algaspring.Enums.UrgencyEnum;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@NofificationType(UrgencyEnum.MEDIUM)
@Component
public class EmailNotificate implements NotificateInterface {

    @Override
    public String notification(Customer customer, String message) {
        System.out.println("Sending email to " + customer.getEmail() + " with message: " + message);
        return (
            "Sending email to " + customer.getEmail() + " with message: " + message);
    }

}
