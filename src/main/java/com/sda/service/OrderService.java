package com.sda.service;


import com.sda.model.Costume;
import com.sda.repository.CostumeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class OrderService {

    private final CostumeRepository costumeRepository;

    public OrderService(CostumeRepository costumeRepository) {
        this.costumeRepository = costumeRepository;
    }
    public Set<Costume> findAll(Long id) {
        if (id == null) {
            return new HashSet<>(costumeRepository.findAll());
        }
        return costumeRepository.findAllById(id);

    }




}
