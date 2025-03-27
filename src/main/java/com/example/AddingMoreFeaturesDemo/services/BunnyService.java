package com.example.AddingMoreFeaturesDemo.services;

import com.example.AddingMoreFeaturesDemo.entities.Bunny;
import com.example.AddingMoreFeaturesDemo.exceptions.ResourceNotFoundException;
import com.example.AddingMoreFeaturesDemo.repositories.BunnyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

        /*Bunny bunny = bunnyRepository.findById(id).orElseThrow(()->{
            System.out.println("logga");
            throw new ResourceNotFoundException("Bunny","Id", id);
        });
        return bunny;*/
        Optional<Bunny> schrodingersBunny = bunnyRepository.findById(id);
        if(schrodingersBunny.isPresent()){
            return schrodingersBunny.get();
        }
        // Implementera loggning
        throw new ResourceNotFoundException("Bunny", "Id", id);
    }

    @Override
    public void removeBunnyById(long id) {
        // Göra en kontroll om entiteten existerar, om inte - kasta ett exception
        bunnyRepository.deleteById(id);
    }


    @Override
    public Bunny addBunny(Bunny bunny) {
        // Har objektet bunny alla nödvändiga attribut?
        if(bunny.getName() == null || bunny.getName().isEmpty()) {
            // Utför åtgärd
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bunny must have a name");
        }
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
