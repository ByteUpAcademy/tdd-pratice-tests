package br.com.tdd.example.tdd_pratice;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.tdd.example.tdd_pratice.bean.CurrencyBean;

@SpringBootApplication
public class TddPraticeApplication {

	public static void main(String[] args) {
		  // Dados fake para ETH
        List<Double> ethHistory = Arrays.asList(1400.0, 1450.0, 1500.0);
        CurrencyBean eth = new CurrencyBean("ETH", 1500.0, 5000000.0, 200000000.0, ethHistory);

        // Dados fake para Bitcoin
        List<Double> bitcoinHistory = Arrays.asList(29000.0, 29500.0, 30000.0);
        CurrencyBean bitcoin = new CurrencyBean("Bitcoin", 30000.0, 10000000.0, 600000000.0, bitcoinHistory);

        // Dados fake para USDT
        List<Double> usdtHistory = Arrays.asList(1.0, 1.0, 1.0);
        CurrencyBean usdt = new CurrencyBean("USDT", 1.0, 100000000.0, 1000000000.0, usdtHistory);

        // Exibindo os dados
        System.out.println(eth);
        System.out.println(bitcoin);
        System.out.println(usdt);
        
		SpringApplication.run(TddPraticeApplication.class, args);
	}

}
