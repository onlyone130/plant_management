package com.example.plantmanagement.controller;

import com.example.plantmanagement.entity.Plant;
import com.example.plantmanagement.repository.PlantRepository;
import com.example.plantmanagement.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plants")
public class PlantController {

    @Autowired
    private PlantService plantService;
    @Autowired
    private PlantRepository plantRepository;

    // Add a new plant
    @PostMapping
    public ResponseEntity<?> addPlant(@RequestBody Plant plant) {
        try {
            // 서비스에서 식물 추가 처리
            Plant savedPlant = plantService.addPlant(plant);
            return new ResponseEntity<>(savedPlant, HttpStatus.CREATED);  // 성공 시 201 응답
        } catch (Exception e) {
            // 예외 발생 시 에러 메시지와 함께 500 반환
            return new ResponseEntity<>("Failed to add plant: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get all plants
    @GetMapping
    public ResponseEntity<List<Plant>> getAllPlants() {
        try {
            // 서비스에서 모든 식물 목록 조회
            List<Plant> plants = plantService.getAllPlants();
            if (plants.isEmpty()) {
                // 식물이 없을 경우 204 No Content 반환
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(plants, HttpStatus.OK);  // 성공 시 200 반환
        } catch (Exception e) {
            e.printStackTrace();
            // 예외 발생 시 500 반환
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get plant by ID
    @GetMapping("/{id}")
    public ResponseEntity<Plant> getPlantById(@PathVariable Long id) {
        // 서비스에서 ID로 식물 조회
        return plantService.getPlantById(id)
                .map(plant -> new ResponseEntity<>(plant, HttpStatus.OK))  // 찾으면 200 반환
                .orElse(new ResponseEntity<>(null, HttpStatus.NOT_FOUND));  // 없으면 404 반환
    }

    // Update a plant
    @PutMapping("/{id}")
    public ResponseEntity<Plant> updatePlant(@PathVariable Long id, @RequestBody Plant updatedPlant) {
        try {
            // 서비스에서 식물 업데이트 처리
            Plant plant = plantService.updatePlant(id, updatedPlant);
            return new ResponseEntity<>(plant, HttpStatus.OK);  // 성공 시 200 반환
        } catch (RuntimeException e) {
            // 예외 발생 시 404 반환
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Delete a plant
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePlant(@PathVariable Long id) {
        try {
            // 서비스에서 식물 삭제 처리
            plantService.deletePlant(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // 성공 시 204 반환
        } catch (Exception e) {
            // 예외 발생 시 500 반환
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
