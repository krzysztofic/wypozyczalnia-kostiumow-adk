package com.sda.repository;

import com.sda.model.Costume;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface CostumeRepository extends PagingAndSortingRepository<Costume, Long> {

    Costume getOne(Long id);

    Optional<Costume> findAllById(Long id);
}
