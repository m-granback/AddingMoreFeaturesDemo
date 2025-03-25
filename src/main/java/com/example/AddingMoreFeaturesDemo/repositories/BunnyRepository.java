package com.example.AddingMoreFeaturesDemo.repositories;


// Bunny DAO

import com.example.AddingMoreFeaturesDemo.entities.Bunny;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BunnyRepository extends JpaRepository<Bunny, Long> {
    // CRUD ingår

    // Möjlighet till extra funktionalitet - Magi, Metodnamnet avgör querien
    List<Bunny> findBunniesByColor(String color);

    List<Bunny> findBunniesByColorContaining(String color);
}
