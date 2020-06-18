package com.sda.repository;

import com.sda.model.Costume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Pageable  extends JpaRepository<Costume, Long> {

}
