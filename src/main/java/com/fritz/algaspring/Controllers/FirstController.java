package com.fritz.algaspring.Controllers;

import com.fritz.algaspring.Entities.Customer;
import com.fritz.algaspring.Services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class FirstController {

    private CustomerService customerService;

    public FirstController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/hello")
    @ResponseBody
    @ResponseStatus(code = HttpStatus.CREATED)
    public String hello() {
        Customer customer = new Customer("fritz", "fritz@fritz.com", "9898989898");

        return customerService.addCustomer(customer);
    }
}
