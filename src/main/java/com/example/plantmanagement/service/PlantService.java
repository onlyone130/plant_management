package com.example.plantmanagement.service;

import com.example.plantmanagement.entity.Plant;
import com.example.plantmanagement.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlantService {

    @Autowired
    private PlantRepository plantRepository;

    // Add a new plant
    public Plant addPlant(Plant plant) {
        try {
            return plantRepository.save(plant);
        } catch (Exception e) {
            // 예외를 로그로 출력하여 문제를 파악할 수 있도록 합니다.
            e.printStackTrace();
            throw new RuntimeException("Failed to save plant: " + e.getMessage());
        }
    }


    // Get all plants
    public List<Plant> getAllPlants() {
        return plantRepository.findAll();
    }

    // Get a plant by ID
    public Optional<Plant> getPlantById(Long id) {
        return plantRepository.findById(id);
    }

    // Update a plant
    public Plant updatePlant(Long id, Plant updatedPlant) {
        return plantRepository.findById(id).map(plant -> {
            plant.setPlantName(updatedPlant.getPlantName());
            plant.setScientificName(updatedPlant.getScientificName());
            // 다른 필드도 업데이트 가능
            return plantRepository.save(plant);
        }).orElseThrow(() -> new RuntimeException("Plant not found with id " + id));
    }

    // Delete a plant
    public void deletePlant(Long id) {
        plantRepository.deleteById(id);
    }
}
