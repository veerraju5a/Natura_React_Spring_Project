package com.natura.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.natura.payload.CartDetailDto;
import com.natura.payload.CartHelp;
import com.natura.repositories.CartDetailsRepo;
import com.natura.repositories.CartRepo;
import com.natura.repositories.UserRepo;
import com.natura.services.CartDetailsService;

public class CartDetailsServiceImpl implements CartDetailsService{

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CartRepo cartRepo;




    @Override
    public CartDetailDto addProduct(CartHelp cartHelp) {
        int productId=cartHelp.getProductId();
        int quantity= cartHelp.getQuantity();
        String userEmail= cartHelp.getUserEmail();




        //get user





        return null;
    }
}
