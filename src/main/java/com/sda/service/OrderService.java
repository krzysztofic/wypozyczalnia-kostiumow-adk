package com.sda.service;


import com.sda.repository.CostumeRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final CostumeRepository costumeRepository;

    public OrderService(CostumeRepository costumeRepository) {
        this.costumeRepository = costumeRepository;
    }
}
