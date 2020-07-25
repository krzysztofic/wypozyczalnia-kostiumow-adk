package com.sda.repository;

import com.sda.model.Costume;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface CostumeRepository extends PagingAndSortingRepository<Costume, Long> {

    Costume getOne(Long id);

    Page<Costume> findByNameLikeIgnoreCase(String name, Pageable page);
}


