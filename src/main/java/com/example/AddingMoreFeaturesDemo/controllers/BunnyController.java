package com.example.AddingMoreFeaturesDemo.controllers;

import com.example.AddingMoreFeaturesDemo.entities.Bunny;
import com.example.AddingMoreFeaturesDemo.services.BunnyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/bunny")
public class BunnyController {

    // JSON = JavaScript Object Notation

    private BunnyService bunnyService;

    @Autowired
    public BunnyController(BunnyService bunnyService) {
        this.bunnyService = bunnyService;
    }
    // @PathVariable, @RequestParam, @RequestBody

    @RequestMapping("/getall")
    @ResponseBody
    public List<Bunny> getAllBunnies(){
        return bunnyService.getAllBunnies();
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public ResponseEntity<Bunny> getById(@PathVariable("id") Long id){
        HttpHeaders headers = new HttpHeaders();
        headers.add("breeder","FlowerPuff Bunnies");
        return new ResponseEntity<>(bunnyService.getBunnyById(id),headers,HttpStatus.OK);
    }

    // @DeleteMapping
    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void removeById(@PathVariable("id") Long id){
        bunnyService.removeBunnyById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Bunny> addNewBunny(@RequestBody Bunny bunny){
        // Statuskod: CREATED

        // Statuskod: OK
//        return ResponseEntity.ok(bunnyService.addBunny(bunny));

        return new ResponseEntity<>(bunnyService.addBunny(bunny), HttpStatus.CREATED);

//        return ResponseEntity.status(HttpStatus.CREATED).body(bunnyService.addBunny(bunny));
    }

//     @PutMapping("/update"),  // TODO     Gå över till @GetMapping, @PutMapping, @PostMapping, @DeleteMapping
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public Bunny updateBunny(@RequestBody Bunny bunny){
       return bunnyService.updateBunny(bunny);

    }

    @RequestMapping(value = "/addwithparams", method = RequestMethod.POST)
    @ResponseBody
    public Bunny addNewBunnyWithParams(@RequestParam("name") String name, @RequestParam("color")String color){
      Bunny bunny = new Bunny(name, color);
        System.out.println("Added with params: " + bunny);
      return bunny;
    }

    @RequestMapping("/getbycolor/{color}")
    @ResponseBody
    public ResponseEntity<List<Bunny>> getAllByColor(@PathVariable("color") String color){
        return ResponseEntity.ok(bunnyService.findBunniesByColor(color));
    }
    @RequestMapping("/getbyadjacentcolor/{color}")
    @ResponseBody
    public List<Bunny> getAllByAdjacentColor(@PathVariable("color") String color){
        return bunnyService.findBunniesByColorContaining(color);
    }
}
