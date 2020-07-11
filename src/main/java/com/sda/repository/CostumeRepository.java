package com.sda.repository;

import com.sda.model.Costume;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface CostumeRepository extends PagingAndSortingRepository<Costume, Long> {

    Costume getOne(Long id);
    List<Costume> findByNameLikeIgnoreCase(String name);
}

