package com.carwash.carwash.repository;

import com.carwash.carwash.entity.cleaner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CleanerRepository extends JpaRepository<cleaner, Long> {

    // Finds cleaners working in same area
    List<cleaner> findByArea(String area);
}

