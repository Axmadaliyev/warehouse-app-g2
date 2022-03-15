package com.example.warehouseapp.repository;

import com.example.warehouseapp.entity.InputProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InputProductRepository extends JpaRepository<InputProduct, UUID> {
}
