package com.example.sjsu.Repository;

import com.example.sjsu.DTO.dogForm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface dogRepository extends JpaRepository<String, Long> {
}
