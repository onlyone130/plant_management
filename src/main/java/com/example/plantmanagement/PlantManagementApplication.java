package com.example.plantmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@SpringBootApplication
public class PlantManagementApplication {
	public static void main(String[] args) {
        SpringApplication.run(PlantManagementApplication.class, args);
	}
}
