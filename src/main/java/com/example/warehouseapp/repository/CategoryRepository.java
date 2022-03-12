package com.example.warehouseapp.repository;

import com.example.warehouseapp.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Integer>{
    Optional<Category>findByActiveTrue();
}
