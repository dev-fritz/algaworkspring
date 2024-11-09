package com.fritz.algaspring.Services;

import com.fritz.algaspring.Annotations.NofificationType;
import com.fritz.algaspring.Entities.Customer;
import com.fritz.algaspring.Enums.UrgencyEnum;
import com.fritz.algaspring.Notification.NotificateInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerService {

    @NofificationType(UrgencyEnum.MEDIUM)
    @Autowired
    private NotificateInterface notificate;

    public String addCustomer(Customer customer) {
        customer.activate();

        return this.notificate.notification(customer, "Welcome to our platform");
    }
}
