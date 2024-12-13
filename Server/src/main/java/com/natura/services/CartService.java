package com.natura.services;

import com.natura.entities.Cart;
import com.natura.payload.CartDto;
import com.natura.payload.CartHelp;
import com.natura.payload.UserDto;

public interface CartService {

    //Create
    CartDto CreateCart(CartHelp cartHelp);

    //add Product To Cart
    CartDto addProductToCart(CartHelp cartHelp);

    //Get
    CartDto GetCart(String userEmail);

    //delete product

    void RemoveById(Integer ProductId,String userEmail);

    //delete


}
