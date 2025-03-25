package com.example.AddingMoreFeaturesDemo.controllers;

import com.example.AddingMoreFeaturesDemo.entities.Bunny;
import com.example.AddingMoreFeaturesDemo.services.BunnyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/bunny")
public class BunnyController {

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
    public Bunny getById(@PathVariable("id") Long id){
        return bunnyService.getBunnyById(id);
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void removeById(@PathVariable("id") Long id){
        bunnyService.removeBunnyById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Bunny addNewBunny(@RequestBody Bunny bunny){
        return bunnyService.addBunny(bunny);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public Bunny updateBunny(@RequestBody Bunny bunny){
       return bunnyService.updateBunny(bunny);

    }

    @RequestMapping(value = "/addwithparams", method = RequestMethod.POST)
    @ResponseBody
    public Bunny addNewBunnyWithParams(@RequestParam("id") long id, @RequestParam("name") String name, @RequestParam("color")String color){
      Bunny bunny = new Bunny(id, name, color);
        System.out.println("Added with params: " + bunny);
      return bunny;
    }

    @RequestMapping("/getbycolor/{color}")
    @ResponseBody
    public List<Bunny> getAllByColor(@PathVariable("color") String color){
        return bunnyService.findBunniesByColor(color);
    }
    @RequestMapping("/getbyadjacentcolor/{color}")
    @ResponseBody
    public List<Bunny> getAllByAdjacentColor(@PathVariable("color") String color){
        return bunnyService.findBunniesByColorContaining(color);
    }
}
