package com.sda.controller;

import com.sda.config.EmailConfig;
import com.sda.model.Customer;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.xml.bind.ValidationException;

@Controller
public class FormController {

    private EmailConfig emailConfig;

    public FormController(EmailConfig emailConfig) {
        this.emailConfig = emailConfig;
    }

    @GetMapping("/rentForm")
    public String sendForm(Customer customer) {
        return "rentForm";
    }

    @PostMapping("/rentForm")
    public String handleCostumeForm(@ModelAttribute Customer customer,
                                    BindingResult bindingResult) throws ValidationException {
        if (bindingResult.hasErrors()) {
            throw new ValidationException("Formularz jest niepoprawny!");
        }

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(this.emailConfig.getHost());
        mailSender.setPort(this.emailConfig.getPort());
        mailSender.setUsername(this.emailConfig.getUsername());
        mailSender.setPassword(this.emailConfig.getPassword());

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(customer.getEmail());
        mailMessage.setTo("biuro@adk.pl");
        mailMessage.setSubject("Nowe zamówienie od "+ customer.getName() + "!");
        mailMessage.setText(customer.getMessage());

        mailSender.send(mailMessage);

        return "thank-you";
    }
}

