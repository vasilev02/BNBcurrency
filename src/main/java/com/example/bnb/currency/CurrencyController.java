package com.example.bnb.currency;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CurrencyController {

    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/download-currencies")
    public ResponseEntity<List<Currency>> getCurrencies() {
        List<Currency> currencyList = currencyService.getDataFromFile();
        return new ResponseEntity<>(currencyList, HttpStatus.OK);
    }
}
