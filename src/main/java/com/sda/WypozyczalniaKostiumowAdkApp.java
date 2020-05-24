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

    @PostConstruct
    public void init() {
        costumeRepository.save(Costume.builder().name("abc").genre(Genre.ANIMALS).sex(Sex.FEMALE).size(Size.BIGMAMMA).borrowedTill(LocalDate.of(2020, 6, 5)).build());
    }
}
