package controller;

import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class CurrencyController {

    private static final String API_KEY = "69d5bb7020e556ad0e2b0d58"; //
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/USD";

    public HashMap<String, Double> getConversionRates() throws IOException {
        String jsonResponse = getResponseFromAPI();
        return parseRates(jsonResponse);
    }

    private String getResponseFromAPI() throws IOException {
        URL url = new URL(API_URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        // Verifica que la respuesta de la API sea exitosa (código 200)
        int responseCode = conn.getResponseCode();
        if (responseCode != 200) {
            throw new IOException("Failed to get response from API, HTTP code: " + responseCode);
        }

        // Leer la respuesta de la API
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println("Response from API: " + response.toString());
        return response.toString();
    }

    private HashMap<String, Double> parseRates(String jsonResponse) {
        JSONObject jsonObject = new JSONObject(jsonResponse);
        JSONObject conversionRates = jsonObject.getJSONObject("conversion_rates");

        HashMap<String, Double> rates = new HashMap<>();
        String[] desiredCurrencies = {"COP", "PEN", "ARS", "BRL", "EUR", "USD"}; // Agrega USD

        for (String currency : desiredCurrencies) {
            if (conversionRates.has(currency)) {
                rates.put(currency, conversionRates.getDouble(currency));
            } else {
                throw new IllegalArgumentException("Currency " + currency + " not supported");
            }
        }

        return rates;
    }
}
