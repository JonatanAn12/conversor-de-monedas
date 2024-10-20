import controller.CurrencyController;
import converter.ExchangeRateConverter;
import java.util.HashMap;
import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) throws Exception {
        CurrencyController currencyController = new CurrencyController();
        HashMap<String, Double> rates = currencyController.getConversionRates();
        ExchangeRateConverter exchangeRateConverter = new ExchangeRateConverter(rates);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Selecciona una opción:");
        System.out.println("1: Dólar a Pesos Colombianos");
        System.out.println("2: Pesos Colombianos a Dólar");
        System.out.println("3: Dólar a Soles Peruanos");
        System.out.println("4: Soles Peruanos a Dólar");
        System.out.println("5: Dólar a Pesos Argentinos");
        System.out.println("6: Pesos Argentinos a Dólar");
        System.out.println("7: Dólar a Reale2s Brasileños");
        System.out.println("8: Reales Brasileños a Dólar");
        System.out.println("9: Dólar a Euros");
        System.out.println("10: Euros a Dólar");

        int option = scanner.nextInt();
        System.out.println("Ingresa la cantidad a convertir:");
        double amount = scanner.nextDouble();

        double result = 0;

        try {
            switch (option) {
                case 1:
                    result = exchangeRateConverter.convert("USD", "COP", amount);
                    System.out.println(amount + " Dólares = " + result + " Pesos Colombianos");
                    break;
                case 2:
                    result = exchangeRateConverter.convert("COP", "USD", amount);
                    System.out.println(amount + " Pesos Colombianos = " + result + " Dólares");
                    break;
                case 3:
                    result = exchangeRateConverter.convert("USD", "PEN", amount);
                    System.out.println(amount + " Dólares = " + result + " Soles Peruanos");
                    break;
                case 4:
                    result = exchangeRateConverter.convert("PEN", "USD", amount);
                    System.out.println(amount + " Soles Peruanos = " + result + " Dólares");
                    break;
                case 5:
                    result = exchangeRateConverter.convert("USD", "ARS", amount);
                    System.out.println(amount + " Dólares = " + result + " Pesos Argentinos");
                    break;
                case 6:
                    result = exchangeRateConverter.convert("ARS", "USD", amount);
                    System.out.println(amount + " Pesos Argentinos = " + result + " Dólares");
                    break;
                case 7:
                    result = exchangeRateConverter.convert("USD", "BRL", amount);
                    System.out.println(amount + " Dólares = " + result + " Reales Brasileños");
                    break;
                case 8:
                    result = exchangeRateConverter.convert("BRL", "USD", amount);
                    System.out.println(amount + " Reales Brasileños = " + result + " Dólares");
                    break;
                case 9:
                    result = exchangeRateConverter.convert("USD", "EUR", amount);
                    System.out.println(amount + " Dólares = " + result + " Euros");
                    break;
                case 10:
                    result = exchangeRateConverter.convert("EUR", "USD", amount);
                    System.out.println(amount + " Euros = " + result + " Dólares");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}
