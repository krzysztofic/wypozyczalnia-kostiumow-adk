package com.sda.controller;

import com.sda.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {

    @GetMapping("/rentForm")
    public String sendForm(Customer customer) {
        return "rentForm";
    }

    @PostMapping("/rentForm")
    public String handleCostumeForm(@ModelAttribute Customer customer) {
        return "thank-you";
    }
}

