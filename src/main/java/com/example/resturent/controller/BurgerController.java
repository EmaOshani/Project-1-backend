package com.example.resturent.controller;

import com.example.resturent.expection.ResourceNotFoundException;
import com.example.resturent.modal.Burger;
import com.example.resturent.repo.BurgerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")

public class BurgerController {

        @Autowired
        private BurgerRepository burgerRepository;

        @GetMapping("/burger")
        public List<Burger> getAllBurger(){ return burgerRepository.findAll();}

        // create burger rest api
        @PostMapping("/burger")
        public Burger createBurger(@RequestBody Burger burger){
            return burgerRepository.save(burger);
        }

        //get burger by id rest api
        @GetMapping("/burger/{id}")
        public ResponseEntity<Burger> getBurgerById(@PathVariable Long id){

            Burger burger = burgerRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Burger not exist with id:" + id));
            return ResponseEntity.ok(burger);
        }


        //update burger rest api
        @PutMapping("/burger/{id}")
        public ResponseEntity<Burger> BurgerUpdate(@PathVariable Long id, @RequestBody Burger burgerDetails){
            Burger burger = burgerRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Burger not exist with id:" + id));

            burger.setName(burgerDetails.getName());
            burger.setPrice(burgerDetails.getPrice());
            burger.setImageURL(burgerDetails.getImageURL());
            burger.setDetails(burgerDetails.getDetails());

            Burger BurgerUpdated = burgerRepository.save(burger);
            return ResponseEntity.ok(BurgerUpdated);
        }

        //delete burger rest api
        @DeleteMapping("/burger/{id}")
        public ResponseEntity<Object> deleteBurger(@PathVariable Long id){
            Burger burger = burgerRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Burger not exist with id:" + id));


            burgerRepository.delete(burger);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return  ResponseEntity.ok(response);
        }
    }

