package com.example.AddingMoreFeaturesDemo.services;

import com.example.AddingMoreFeaturesDemo.entities.Bunny;
import com.example.AddingMoreFeaturesDemo.repositories.BunnyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BunnyService implements BunnyServiceInterface {

    private BunnyRepository bunnyRepository;

    @Autowired
    public BunnyService(BunnyRepository bunnyRepository) {
        this.bunnyRepository = bunnyRepository;
    }
    @Override
    public List<Bunny> getAllBunnies(){
        return bunnyRepository.findAll();
    }
    @Override
    public Bunny getBunnyById(long id){
        Optional<Bunny> schrodingersBunny = bunnyRepository.findById(id);
        if(schrodingersBunny.isPresent()){
            return schrodingersBunny.get();
        }
        return null;
    }

    @Override
    public void removeBunnyById(long id) {
        // Göra en kontroll om entiteten existerar, om inte - kasta ett exception
        bunnyRepository.deleteById(id);
    }

    @Override
    public Bunny addBunny(Bunny bunny) {
        return bunnyRepository.save(bunny);

    }

    @Override
    public Bunny updateBunny(Bunny bunny) {

        return bunnyRepository.save(bunny);
    }

    @Override
    public List<Bunny> findBunniesByColor(String color) {
        return bunnyRepository.findBunniesByColor(color);
    }

    @Override
    public List<Bunny> findBunniesByColorContaining(String color) {
        return bunnyRepository.findBunniesByColorContaining(color);
    }


}
