package br.com.tdd.example.tdd_pratice.service;

import java.util.List;

import br.com.tdd.example.tdd_pratice.bean.CurrencyBean;

public interface CurrencyService {
	
    CurrencyBean getCurrencyDetails(String name);
    List<CurrencyBean> getAllCurrencies();

}