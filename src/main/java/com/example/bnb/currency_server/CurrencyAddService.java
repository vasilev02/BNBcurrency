package com.example.bnb.currency_server;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CurrencyAddService {

    private final CurrencyServerRepository currencyServerRepository;

    public CurrencyAddService(CurrencyServerRepository currencyServerRepository) {
        this.currencyServerRepository = currencyServerRepository;
    }

    public void addCurrenciesFromServer(String serverData) {

        try {
            this.currencyServerRepository.deleteAllData();
            this.currencyServerRepository.resetIdSequence();

            ObjectMapper objectMapper = new ObjectMapper();
            CurrencyFromServer[] currencies = objectMapper.readValue(serverData, CurrencyFromServer[].class);
            System.out.println(Arrays.toString(currencies));
            currencyServerRepository.saveAll(Arrays.asList(currencies));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
