package com.sda.service;

import com.sda.model.Costume;
import com.sda.repository.CostumeRepository;
import org.springframework.stereotype.Service;
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
    public Costume getOne(Long id) {
        return costumeRepository.getOne(id);
    }
}
