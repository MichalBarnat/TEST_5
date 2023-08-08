package zad2;

import zad2.service.CurrencyService;

public class Main {
    public static void main(String[] args) {
        double a = CurrencyService.exchange("PLN", "USD", 200);

        System.out.println(a);
    }
}
