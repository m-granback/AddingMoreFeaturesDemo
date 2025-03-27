package com.example.AddingMoreFeaturesDemo.services;

import com.example.AddingMoreFeaturesDemo.entities.Fox;

import java.util.List;

public interface FoxServiceInterface {

    Fox addFox(Fox fox);
    Fox getFoxById(Long id);
    void deleteFoxById(Long id);
    List<Fox> getAllFoxes();
    Fox updateFox(Fox fox);
}
