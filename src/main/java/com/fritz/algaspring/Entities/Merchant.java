package com.fritz.algaspring.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Merchant {
    @Id
    private Long id;

    private String name;

    private String description;

    private String address;

    private String phone;

    private BigDecimal deliveryTax;

    public BigDecimal getDeliveryTax() {
        return deliveryTax;
    }

    public void setDeliveryTax(BigDecimal deliveryTax) {
        this.deliveryTax = deliveryTax;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
