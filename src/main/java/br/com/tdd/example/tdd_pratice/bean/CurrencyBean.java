package br.com.tdd.example.tdd_pratice.bean;

import java.util.List;

import lombok.Data;

@Data
public class CurrencyBean {
    private String name;
    private double value;
    private double liquidity; // Liquidez
    private double marketCap; // Valor de mercado
    private List<Double> historicalValues; // Histórico de valores

    // Construtor para inicializar todos os campos
    public CurrencyBean(String name, double value, double liquidity, double marketCap, List<Double> historicalValues) {
        this.name = name;
        this.value = value;
        this.liquidity = liquidity;
        this.marketCap = marketCap;
        this.historicalValues = historicalValues;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public double getLiquidity() {
		return liquidity;
	}

	public void setLiquidity(double liquidity) {
		this.liquidity = liquidity;
	}

	public double getMarketCap() {
		return marketCap;
	}

	public void setMarketCap(double marketCap) {
		this.marketCap = marketCap;
	}

	public List<Double> getHistoricalValues() {
		return historicalValues;
	}

	public void setHistoricalValues(List<Double> historicalValues) {
		this.historicalValues = historicalValues;
	}
    
    
    
}