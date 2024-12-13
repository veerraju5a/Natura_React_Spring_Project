package com.natura.controllers;


import com.natura.payload.PaymentDetails;
import com.natura.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/{amount}")
    public ResponseEntity<PaymentDetails> CreatePayment(@PathVariable Double amount){
        PaymentDetails paymentDetails = this.paymentService.CreateOrder(amount);
        return new ResponseEntity<>(paymentDetails, HttpStatusCode.valueOf(200));
    }

}



