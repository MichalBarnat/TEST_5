package zad2.service;

import org.junit.Test;

import static org.junit.Assert.*;

public class CurrencyServiceTest {

    @Test
    public void shouldReturn49USDfrom200PLN() {
        assertEquals(49, CurrencyService.exchange("PLN", "USD", 200), 1.0);
    }

    @Test
    public void shouldReturn465PLNfrom100CHF() {
        assertEquals(465, CurrencyService.exchange("CHF", "PLN", 100), 1.0);
    }

}