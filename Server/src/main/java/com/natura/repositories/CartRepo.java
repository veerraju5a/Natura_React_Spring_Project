package com.natura.repositories;


import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.natura.entities.Cart;
import com.natura.entities.User;
import com.natura.payload.CartDto;


public interface CartRepo extends JpaRepository<Cart,Integer> {
   public Cart findByUser(User user);
//   public Cart findByUser_id(Integer Id);
}
