package com.sda.service;

import com.sda.model.Costume;
import com.sda.repository.CostumeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private CostumeRepository costumeRepository;

    public OrderService(CostumeRepository costumeRepository) {
        this.costumeRepository = costumeRepository;
    }

    public Page<Costume> findAll(PageRequest page) {
        return costumeRepository.findAll(page);
    }
}
