package com.sda.model;

import lombok.Builder;
import lombok.Data;

@Data
public class User {

    private String name;
    private String email;
    private String message;


    public User() {
    }
}