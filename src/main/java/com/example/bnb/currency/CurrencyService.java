package com.example.bnb.currency;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CurrencyService {

    private final CurrencyRepository currencyRepository;

    public CurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    public List<Currency> getDataFromFile() {
        List<Currency> currencyList = new ArrayList<>();
        XmlMapper mapper = new XmlMapper();

        this.currencyRepository.deleteAllData();
        this.currencyRepository.resetIdSequence();
        try {
            ArrayNode arrayNode = (ArrayNode) mapper.readTree(new File(CurrencyService.class.getResource("../../../../Exchange_Rates.xml").getFile())).get("ROW");
            for (int i = 1; i < arrayNode.size(); i++) {
                ObjectNode entry = (ObjectNode) arrayNode.get(i);
                Currency currency = new Currency();
                currency.setCode(entry.get("CODE").asText());
                currency.setName(entry.get("NAME_").asText());
                currency.setRatio(entry.path("RATIO").asInt(1));
                currency.setExchangeRate(entry.path("RATE").asDouble(1.0));
                currency.setReverseExchangeRate(entry.path("REVERSERATE").asDouble(1.0));
                this.currencyRepository.save(currency);
                currencyList.add(currency);
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        return currencyList;
    }

}
