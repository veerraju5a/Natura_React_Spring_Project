package com.natura.services;

import org.springframework.stereotype.Service;

import com.natura.payload.CartDetailDto;
import com.natura.payload.CartHelp;

@Service
public interface CartDetailsService {

    //add product
    public CartDetailDto addProduct(CartHelp cartHelp);
}
