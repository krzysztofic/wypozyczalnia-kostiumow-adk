package com.sda.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer {

    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String message;
}