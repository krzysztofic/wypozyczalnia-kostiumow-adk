package com.sda;

import com.sda.model.Costume;
import com.sda.model.Genre;
import com.sda.model.Sex;
import com.sda.model.Size;
import com.sda.repository.CostumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@SpringBootApplication
public class WypozyczalniaKostiumowAdkApp {

    public static void main(String[] args) {
        SpringApplication.run(WypozyczalniaKostiumowAdkApp.class, args);
    }

@Autowired
    private CostumeRepository costumeRepository;

    }
