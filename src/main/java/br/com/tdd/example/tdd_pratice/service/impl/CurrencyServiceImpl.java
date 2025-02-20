package br.com.tdd.example.tdd_pratice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tdd.example.tdd_pratice.bean.CurrencyBean;
import br.com.tdd.example.tdd_pratice.repository.FakeData;
import br.com.tdd.example.tdd_pratice.service.CurrencyService;

@Service
public class CurrencyServiceImpl implements CurrencyService {

	 @Autowired
	  private FakeData fakeDatabase;

	    @Override
	    public CurrencyBean getCurrencyDetails(String name) {
	        // Busca a moeda na base de dados fake
	        CurrencyBean currency = this.fakeDatabase.getCurrency(name.toUpperCase());

	        // Verifica se a moeda foi encontrada
	        if (currency == null) {
	            throw new IllegalArgumentException("Moeda não suportada: " + name);
	        }

	        // Retorna os detalhes da moeda
	        return currency;
	    }

	    @Override
	    public List<CurrencyBean> getAllCurrencies() {
	        // Retorna todas as moedas disponíveis na base de dados fake
	        return fakeDatabase.getAllCurrencies();
	    }
 
}