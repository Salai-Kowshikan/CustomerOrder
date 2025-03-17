package com.NaanMudhalvan.CustomerOrder.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class CustomerDTO {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String name;

    private String email;
}