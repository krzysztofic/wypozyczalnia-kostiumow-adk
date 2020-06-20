package com.sda.repository;

import com.sda.model.Costume;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface CostumeRepository extends JpaRepository<Costume, Long> {

    List<Costume> findByNameLikeIgnoreCase(String name);
}

