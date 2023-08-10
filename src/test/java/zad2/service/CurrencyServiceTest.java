package zad2.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

public class CurrencyServiceTest {

    private CurrencyService currencyService;
    @Mock
    private HttpClient httpClientMock;
    @Mock
    private HttpResponse<String> httpResponseMock;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
        currencyService = new CurrencyService();
        currencyService.setClient(httpClientMock);
    }

    @Test
    public void testExchange() {
        String responseBody = "{\"result\": 404.9}";
        double expectedConvertedValue = 404.9;

        Mockito.when(httpResponseMock.body()).thenReturn(responseBody);
        Mockito.when(httpClientMock.sendAsync(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
                .thenReturn(CompletableFuture.completedFuture(httpResponseMock));


        double actualConvertedValue = currencyService.exchange("USD", "PLN", 100.0);

        assertEquals(actualConvertedValue, expectedConvertedValue, 0.1);

    }

    @Test
    public void shouldReturnCorrectValueFromJson() {
        String responseBody = "{\"result\": 500.0}";
        double expectedValue = 500.0;
        double actualValue = currencyService.parseJSON(responseBody);

        assertEquals(actualValue, expectedValue, 0.1);
    }


}