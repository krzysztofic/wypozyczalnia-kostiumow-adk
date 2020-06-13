package com.sda.service;


import com.sda.model.*;
import com.sda.repository.CostumeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public Optional<Costume> borrowCostume(Long id) {
        Optional<Costume> notBorrowedCostume = costumeRepository.findAllById(id).stream()
                .filter(costume -> costume.getBorrowedTill() == null).findAny();
        if (notBorrowedCostume.isPresent()) {
            Costume costumeToBorrow = notBorrowedCostume.get();
            costumeToBorrow.setBorrowedTill(LocalDate.now().plusDays(7));
            return Optional.of(costumeRepository.save(costumeToBorrow));
        }
        return notBorrowedCostume;
    }

    public Costume returnCostume(Long id) {
        Costume costumeToReturn = costumeRepository.findById(id).get();
        costumeToReturn.setBorrowedTill(null);
        return costumeRepository.save(costumeToReturn);
    }
}
