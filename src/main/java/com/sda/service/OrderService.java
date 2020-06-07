package com.sda.service;


import com.sda.model.*;
import com.sda.repository.CostumeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final CostumeRepository costumeRepository;

    public OrderService(CostumeRepository costumeRepository) {
        this.costumeRepository = costumeRepository;
    }
    public List<Costume> findAll() {
        return costumeRepository.findAll();
    }
    public List<Costume> listAll() {
        List<Costume> costumes = new ArrayList<>();
        costumeRepository.findAll().forEach(costumes::add);
        return costumes;
    }
    public Costume add(Long id, String name, Size size, Genre genre, Sex sex, LocalDate borrowedTill, String imageUrl, Double price) {
        return costumeRepository.save(new Costume(id, name, size, genre, sex, borrowedTill, imageUrl, price));
    }

    public void remove(Long id) {
        costumeRepository.delete(costumeRepository.findById(id).get());
    }
}
