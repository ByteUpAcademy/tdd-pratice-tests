package br.com.tdd.example.tdd_pratice.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import br.com.tdd.example.tdd_pratice.bean.CurrencyBean;
import br.com.tdd.example.tdd_pratice.service.CurrencyService;

@WebMvcTest(CurrencyController.class) // Carrega apenas o controller para o teste
public class CurrencyControllerTest {

    @Autowired
    private MockMvc mockMvc; // Simula requisições HTTP

    @MockBean
    private CurrencyService currencyService; // Mock do serviço

    @Test
    public void testGetCurrencyDetailsETH() throws Exception {
        // 1. Mockando os dados
        List<Double> ethHistory = Arrays.asList(1400.0, 1450.0, 1500.0);
        CurrencyBean eth = new CurrencyBean("ETH", 1500.0, 5000000.0, 200000000.0, ethHistory);

        // 2. Configurando o mock do serviço
        Mockito.when(currencyService.getCurrencyDetails("ETH")).thenReturn(eth);

        // 3. Fazendo a requisição e verificando o resultado
        mockMvc.perform(MockMvcRequestBuilders.get("/currencies/ETH")) // Faz a requisição GET
               .andExpect(status().isOk()) // Verifica se o status é 200 (OK)
               .andExpect(jsonPath("$.name").value("ETH")) // Verifica o nome da moeda
               .andExpect(jsonPath("$.value").value(1500.0)) // Verifica o valor
               .andExpect(jsonPath("$.liquidity").value(5000000.0)) // Verifica a liquidez
               .andExpect(jsonPath("$.marketCap").value(200000000.0)) // Verifica o market cap
               .andExpect(jsonPath("$.historicalValues").isArray()) // Verifica se o histórico é um array
               .andExpect(jsonPath("$.historicalValues.length()").value(3)); // Verifica o tamanho do histórico
    }
}