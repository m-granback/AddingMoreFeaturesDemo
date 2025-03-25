package com.example.AddingMoreFeaturesDemo.services;

import com.example.AddingMoreFeaturesDemo.entities.Bunny;

import java.util.List;

public interface BunnyServiceInterface {

    List<Bunny> getAllBunnies();
    Bunny getBunnyById(long id);
    void removeBunnyById(long id);
    Bunny addBunny(Bunny bunny);
    Bunny updateBunny(Bunny bunny);
    List<Bunny> findBunniesByColor(String color);
    List<Bunny> findBunniesByColorContaining(String color);
}
