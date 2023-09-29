package com.example.resturent.controller;


import com.example.resturent.dto.OrderRequest;
import com.example.resturent.dto.OrderResponse;
import com.example.resturent.entity.Customer;
import com.example.resturent.entity.Product;
import com.example.resturent.expection.ResourceNotFoundException;
import com.example.resturent.repo.CustomerRepository;
import com.example.resturent.repo.ProductRepository;
import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")

public class OrderController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/placeOrder")
    public Customer placeOrder(@RequestBody OrderRequest request){
        return customerRepository.save(request.getCustomer());
    }

    //get order by id rest api
    @GetMapping("/getDetails/{id}")
    public ResponseEntity<Customer> getOrderById(@PathVariable int id){

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not exist with id:" + id));
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/findAllOrder")
    public List<Customer> findAllOrders(){
        return customerRepository.findAll();
    }

    @GetMapping("/getInfo")
    public List<OrderResponse> getJoinInformation(){
        return customerRepository.getJoinInformation();
    }

    @PutMapping("/updateOrderState/{id}")
    public ResponseEntity<Customer> updateOrderState(@PathVariable int id, @RequestBody Customer OrderStates) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException(" order not exist with id :" + id));
        customer.setStates(OrderStates.getStates());

        Customer updateStates = customerRepository.save(customer);
        return ResponseEntity.ok(updateStates);
    }



    @GetMapping("/findSellsOrder")
    public List<Product> findConfirmedProducts() {
        List<Customer> customers = customerRepository.findAll();
        List<Product> confirmedProducts = new ArrayList<>();

        for (Customer customer : customers) {
            if (customer.getStates().equals("confirem") && customer.getProducts() != null) {
                confirmedProducts.addAll(customer.getProducts());
            }
        }

        return confirmedProducts;
    }



}



