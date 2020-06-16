package com.sda;

import com.sda.repository.CostumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WypozyczalniaKostiumowAdkApp {

    public static void main(String[] args) {
        SpringApplication.run(WypozyczalniaKostiumowAdkApp.class, args);
    }

    @Autowired
    private CostumeRepository costumeRepository;
}
