package zad2.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import zad2.model.OurClient;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class CurrencyServiceTest {

    @Mock
    private OurClient client;

    @InjectMocks
    private CurrencyService currencyService;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldReturnCorrectValueWhenExchanging() {
        double amount = 100.0;
        String from = "EUR";
        String to = "PLN";
        double expectedAmount = 446.3795;

        when(client.getJson(amount, from, to)).thenReturn(jsonFromApi());

        double ourResult = currencyService.exchange(amount, from, to);

        assertEquals(expectedAmount, ourResult, 0.001);
    }

    @Test
    public void shouldReturnCorrectValueWhenAskForHistoricalData() {
        double amount = 100.0;
        String from = "EUR";
        String to = "PLN";
        String date = "2000-01-01";
        double expectedAmount = 416.8164;

        when(client.getJson(amount, from, to, date)).thenReturn(jsonHistoricalFromApi());

        double ourResult = currencyService.exchange(amount, from, to, date);

        assertEquals(expectedAmount, ourResult, 0.001);
    }

    private String jsonFromApi() {
        return "{\n" +
                "    \"success\": true,\n" +
                "    \"query\": {\n" +
                "        \"from\": \"EUR\",\n" +
                "        \"to\": \"PLN\",\n" +
                "        \"amount\": 100\n" +
                "    },\n" +
                "    \"info\": {\n" +
                "        \"timestamp\": 1697980023,\n" +
                "        \"rate\": 4.463795\n" +
                "    },\n" +
                "    \"date\": \"2023-10-22\",\n" +
                "    \"result\": 446.3795\n" +
                "}";
    }

    private String jsonHistoricalFromApi() {
        return "{\n" +
                "    \"success\": true,\n" +
                "    \"query\": {\n" +
                "        \"from\": \"EUR\",\n" +
                "        \"to\": \"PLN\",\n" +
                "        \"amount\": 100\n" +
                "    },\n" +
                "    \"info\": {\n" +
                "        \"timestamp\": 946771199,\n" +
                "        \"rate\": 4.168164\n" +
                "    },\n" +
                "    \"date\": \"2000-01-01\",\n" +
                "    \"historical\": true,\n" +
                "    \"result\": 416.8164\n" +
                "}";
    }

}