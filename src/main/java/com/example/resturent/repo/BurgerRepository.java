package com.example.resturent.repo;

import com.example.resturent.modal.Burger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BurgerRepository extends JpaRepository<Burger, Long> {
}
