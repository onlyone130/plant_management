package com.example.plantmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long plantId;

    @NotNull
    private String plantName;

    private String scientificName;
    private String species;

    // Adding missing fields based on the MySQL table structure
    private String difficultyLevel;  // 'easy', 'moderate', 'hard'
    private Integer wateringFrequency;  // Frequency in days
    private String fertilizerType;  // As per the table structure
    private String growthNotes;  // Text notes

    public Long getPlantId() {
        return plantId;
    }

    public void setPlantId(Long plantId) {
        this.plantId = plantId;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public Integer getWateringFrequency() {
        return wateringFrequency;
    }

    public void setWateringFrequency(Integer wateringFrequency) {
        this.wateringFrequency = wateringFrequency;
    }

    public String getFertilizerType() {
        return fertilizerType;
    }

    public void setFertilizerType(String fertilizerType) {
        this.fertilizerType = fertilizerType;
    }

    public String getGrowthNotes() {
        return growthNotes;
    }

    public void setGrowthNotes(String growthNotes) {
        this.growthNotes = growthNotes;
    }
}
