package br.com.tdd.example.tdd_pratice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tdd.example.tdd_pratice.bean.CurrencyBean;
import br.com.tdd.example.tdd_pratice.service.CurrencyService;

@RestController
@RequestMapping("/currencies")
public class CurrencyController {
	@Autowired
    private CurrencyService currencyService;

    // Endpoint para buscar detalhes de uma moeda específica
    @GetMapping("/{nome}")
    public ResponseEntity<CurrencyBean> getCurrencyDetails(@PathVariable String nome) {
        CurrencyBean currency = currencyService.getCurrencyDetails(nome);
        return ResponseEntity.ok(currency);
    }

    // Endpoint para listar todas as moedas disponíveis
    @GetMapping
    public ResponseEntity<List<CurrencyBean>> getAllCurrencies() {
        List<CurrencyBean> currencies = currencyService.getAllCurrencies();
        return ResponseEntity.ok(currencies);
    }
}
