package com.natura.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.natura.entities.Product;

public interface ProductRepo extends JpaRepository<Product,Integer> {
}
