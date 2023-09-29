package com.example.resturent.repo;

import com.example.resturent.modal.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository <Pizza, Long> {
}
