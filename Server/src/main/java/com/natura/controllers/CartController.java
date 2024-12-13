package com.natura.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.natura.entities.Cart;
import com.natura.payload.ApiResponse;
import com.natura.payload.CartDto;
import com.natura.payload.CartHelp;
import com.natura.payload.UserDto;
import com.natura.services.CartService;

import java.security.Principal;

import static org.apache.coyote.http11.Constants.a;

@RestController
@CrossOrigin("*")
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;


    @PostMapping("/addproduct")
    public ResponseEntity<CartDto> addProduct(@RequestBody CartHelp cartHelp,Principal principal){
        String userEmail = principal.getName();
        cartHelp.setUserEmail(userEmail);
        CartDto cartDto = this.cartService.addProductToCart(cartHelp);
        return new ResponseEntity<>(cartDto, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/{userid}")
    public ResponseEntity<CartDto> GetCart(Principal principal){
        String userEmail = principal.getName();
        CartDto cartDto = this.cartService.GetCart(userEmail);

        return new ResponseEntity<>(cartDto, HttpStatusCode.valueOf(200));
    }


    @DeleteMapping("/product/{productid}")
    public ResponseEntity<ApiResponse> DeleteItem(Principal principal, @PathVariable Integer productid){
        String userEmail = principal.getName();
        this.cartService.RemoveById(productid,userEmail);

        return new ResponseEntity<>(new ApiResponse("remove"),HttpStatusCode.valueOf(200));
    }
}
