package com.example.bnb.currency_server;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyAddController {

    private final CurrencyAddService currencyAddService;

    public CurrencyAddController(CurrencyAddService currencyAddService) {
        this.currencyAddService = currencyAddService;
    }

    @PostMapping("/add-currencies")
    public ResponseEntity<String> addCurrencies(@RequestBody String body) {
        this.currencyAddService.addCurrenciesFromServer(body);
        System.out.println("The body is " + body);
        return new ResponseEntity<>("Received JSON", HttpStatus.CREATED);
    }
}