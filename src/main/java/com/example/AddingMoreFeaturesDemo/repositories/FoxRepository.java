package com.example.AddingMoreFeaturesDemo.repositories;

import com.example.AddingMoreFeaturesDemo.entities.Fox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoxRepository extends JpaRepository<Fox, Long> {
    // CRUD-funktionaliteten
}
