package com.example.plantmanagement.repository;

import com.example.plantmanagement.entity.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantRepository extends JpaRepository<Plant, Long> {
}
