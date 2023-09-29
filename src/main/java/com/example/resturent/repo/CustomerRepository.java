package com.example.resturent.repo;

import com.example.resturent.dto.OrderResponse;
import com.example.resturent.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    @Query("SELECT new com.example.resturent.dto.OrderResponse(c.name , p.name) FROM Customer c JOIN c.products p")
    public List<OrderResponse> getJoinInformation();
}
