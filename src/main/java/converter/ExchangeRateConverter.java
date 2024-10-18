package converter;

import java.util.HashMap;

public class ExchangeRateConverter {
    private HashMap<String, Double> rates;

    public ExchangeRateConverter(HashMap<String, Double> rates) {
        this.rates = rates;
    }

    public double convert(String fromCurrency, String toCurrency, double amount) {
        Double fromRate = rates.get(fromCurrency);
        Double toRate = rates.get(toCurrency);


        if (fromRate == null || toRate == null) {
            throw new IllegalArgumentException("Currency not supported");
        }

        return amount * (toRate / fromRate);
    }
}
