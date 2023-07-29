package com.example.sjsu.Repository;

import com.example.sjsu.DTO.dogForm;
import com.example.sjsu.domain.dog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface dogRepository extends JpaRepository<dog, Long> {
}
