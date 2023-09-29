package com.example.resturent.controller;

import com.example.resturent.expection.ResourceNotFoundException;
import com.example.resturent.modal.Pizza;
import com.example.resturent.repo.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class PizzaController {

    @Autowired
    private PizzaRepository pizzaRepository;

    @GetMapping("/pizza")
    public List<Pizza>getAllPizza(){
        return pizzaRepository.findAll();
    }

  // create pizza rest api
    @PostMapping("/pizza")
    public Pizza createPizza(@RequestBody Pizza pizza){
        return pizzaRepository.save(pizza);
    }

    //get pizza by id rest api
    @GetMapping("/pizza/{id}")
    public ResponseEntity< Pizza> getPizzaById(@PathVariable Long id){

        Pizza pizza = pizzaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pizza not exist with id:" + id));
        return ResponseEntity.ok(pizza);
    }


   //update pizza rest api
    @PutMapping("/pizza/{id}")
    public ResponseEntity<Pizza> updatePizza(@PathVariable Long id, @RequestBody Pizza pizzaDetails){
        Pizza  pizza = pizzaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pizza not exist with id:" + id));

        pizza.setName(pizzaDetails.getName());
        pizza.setLargeprice(pizzaDetails.getLargeprice());
        pizza.setMediumprice(pizzaDetails.getMediumprice());
        pizza.setSmallprice(pizzaDetails.getSmallprice());
        pizza.setImageURL(pizzaDetails.getImageURL());
        pizza.setDetails(pizzaDetails.getDetails());

        Pizza updatedPizza = pizzaRepository.save(pizza);
        return ResponseEntity.ok(updatedPizza);
    }

    //delete pizza rest api
    @DeleteMapping("/pizza/{id}")
    public ResponseEntity<Object> deletePizza(@PathVariable Long id){
        Pizza  pizza = pizzaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pizza not exist with id:" + id));

        pizzaRepository.delete(pizza);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return  ResponseEntity.ok(response);
    }
}