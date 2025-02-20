package br.com.tdd.example.tdd_pratice.repository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.com.tdd.example.tdd_pratice.bean.CurrencyBean;

@Repository
public class FakeData {

    private final Map<String, CurrencyBean> database;

    public FakeData() {
        this.database = new HashMap<>();
        populateDatabase();
    }

    private void populateDatabase() {
        // Dados fake para ETH
        List<Double> ethHistory = Arrays.asList(1400.0, 1450.0, 1500.0);
        database.put("ETH", new CurrencyBean("ETH", 1500.0, 5000000.0, 200000000.0, ethHistory));

        // Dados fake para Bitcoin
        List<Double> bitcoinHistory = Arrays.asList(29000.0, 29500.0, 30000.0);
        database.put("BITCOIN", new CurrencyBean("Bitcoin", 30000.0, 10000000.0, 600000000.0, bitcoinHistory));

        // Dados fake para USDT
        List<Double> usdtHistory = Arrays.asList(1.0, 1.0, 1.0);
        database.put("USDT", new CurrencyBean("USDT", 1.0, 100000000.0, 1000000000.0, usdtHistory));
    }

    public CurrencyBean getCurrency(String name) {
        return database.get(name.toUpperCase());
    }

    public List<CurrencyBean> getAllCurrencies() {
        return List.copyOf(database.values());
    }
}