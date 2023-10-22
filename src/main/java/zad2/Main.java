package zad2;

import zad2.model.OurClient;
import zad2.service.CurrencyService;

public class Main {

    public static void main(String[] args) {
        OurClient client = new OurClient();

        String test = client.getJson(100, "EUR", "PLN");

        System.out.println(test);

        String testHistorical = client.getJson(100, "EUR", "PLN", "2000-01-01");

        System.out.println(testHistorical);

        CurrencyService currencyService = new CurrencyService(client);

        System.out.println(currencyService.exchange(100, "EUR", "PLN"));
    }


}
