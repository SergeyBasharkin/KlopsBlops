package com.springapp.mvc.common;

import javax.persistence.*;

/**
 * Created by sergey on 13.04.16.
 */
@Entity
@Table(name = "h_orders")
public class OrderInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public OrderInfo() {

    }

    public OrderInfo(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }
}
