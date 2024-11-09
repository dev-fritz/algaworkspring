package com.fritz.algaspring.Notification;

import com.fritz.algaspring.Entities.Customer;

public interface NotificateInterface {
    public String notification(Customer customer, String message);
}
