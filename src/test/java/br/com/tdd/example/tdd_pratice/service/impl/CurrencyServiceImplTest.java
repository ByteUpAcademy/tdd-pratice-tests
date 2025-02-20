package br.com.tdd.example.tdd_pratice.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.lang.reflect.Executable;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.tdd.example.tdd_pratice.bean.CurrencyBean;
import br.com.tdd.example.tdd_pratice.repository.FakeData;

@SpringBootTest
public class CurrencyServiceImplTest {

	@Mock
	private FakeData fakeDatabase;

	@InjectMocks
	private CurrencyServiceImpl currencyService;

	@Test
	public void testGetCurrencyDetailsETH() {
	    // 01 - Mockando os dados
	    List<Double> ethHistory = Arrays.asList(1400.0, 1450.0, 1500.0);
	    CurrencyBean eth = new CurrencyBean("ETH", 1500.0, 5000000.0, 200000000.0, ethHistory);

	    // 02 - Forçando retornos
	    when(fakeDatabase.getCurrency("ETH")).thenReturn(eth);

	    // 03 - Action
	    CurrencyBean resultado = currencyService.getCurrencyDetails("ETH");

	    // 04 - Verifica os resultados
	    assertEquals("ETH", resultado.getName());
	    assertEquals(1500.0, resultado.getValue());
	    assertEquals(5000000.0, resultado.getLiquidity());
	    assertEquals(200000000.0, resultado.getMarketCap());
	    assertEquals(ethHistory, resultado.getHistoricalValues());
	}

	@Test
	public void testGetCurrencyDetailsNotFound() {
	    // Given (Dado que)
	    String nomeMoeda = "DOGECOIN"; // Moeda não suportada
	    when(fakeDatabase.getCurrency(nomeMoeda)).thenReturn(null); // Simula que a moeda não existe

	    // When (Quando) e Then (Então)
	    IllegalArgumentException exception = assertThrows(
	        IllegalArgumentException.class,
	        () -> currencyService.getCurrencyDetails(nomeMoeda) // Expressão lambda diretamente
	    );

	    assertEquals("Moeda não suportada: " + nomeMoeda, exception.getMessage()); // Verifica a mensagem da exceção
	}

	@Test
	public void testGetAllCurrencies() {
		// Dados fake para todas as moedas
		List<Double> ethHistory = Arrays.asList(1400.0, 1450.0, 1500.0);
		CurrencyBean eth = new CurrencyBean("ETH", 1500.0, 5000000.0, 200000000.0, ethHistory);

		List<Double> bitcoinHistory = Arrays.asList(29000.0, 29500.0, 30000.0);
		CurrencyBean bitcoin = new CurrencyBean("Bitcoin", 30000.0, 10000000.0, 600000000.0, bitcoinHistory);

		List<CurrencyBean> allCurrencies = Arrays.asList(eth, bitcoin);

		// Configura o mock para retornar todas as moedas
		when(fakeDatabase.getAllCurrencies()).thenReturn(allCurrencies);

		// Chama o método do serviço
		List<CurrencyBean> resultado = currencyService.getAllCurrencies();

		// Verifica os resultados
		assertEquals(2, resultado.size());
		assertEquals("ETH", resultado.get(0).getName());
		assertEquals("Bitcoin", resultado.get(1).getName());
	}
}