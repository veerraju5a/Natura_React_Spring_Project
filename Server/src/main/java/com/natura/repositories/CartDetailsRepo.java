package com.natura.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.natura.entities.Cart;
import com.natura.entities.CartDetalis;
import com.natura.entities.Product;

public interface CartDetailsRepo extends JpaRepository<CartDetalis,Integer> {
    public void deleteByProductsAndCart(Product product, Cart cart);
    public CartDetalis findByProductsAndCart(Product product, Cart cart);
}
