package com.fritz.algaspring.Notification;

import com.fritz.algaspring.Annotations.NofificationType;
import com.fritz.algaspring.Entities.Customer;
import com.fritz.algaspring.Enums.UrgencyEnum;
import org.springframework.stereotype.Component;

@NofificationType(UrgencyEnum.LOW)
@Component
public class SmsNotificate implements NotificateInterface {

    @Override
    public String notification(Customer customer, String message) {
        System.out.println("Sending sms to " + customer.getPhone() + " with message: " + message);
        return (
                "Sending sms to " + customer.getPhone() + " with message: " + message);
    }

}
