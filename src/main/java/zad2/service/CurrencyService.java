package zad2.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyService {

    public static double exchange(String CurrencyFrom, String CurrencyTo, double amount) {
        String baseUrl = "https://api.apilayer.com/currency_data/";
        String apiKey = "TMrs25g3tBZe2qvKJNgMqcQOMNAQe1Md";
        String urlStr = baseUrl + "convert?amount=" + amount + "&from=" + CurrencyFrom + "&to=" + CurrencyTo + "&apikey=" + apiKey;
        //System.out.println(urlStr);

        //http request
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlStr)).build();
        String responseBody = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .join();

        double convertedValue = parseJSON(responseBody);

        return convertedValue;
    }

    public static double parseJSON(String responseBody) {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(responseBody, JsonObject.class);

        if (jsonObject != null && jsonObject.has("result")) {
            return jsonObject.get("result").getAsDouble();
        } else {
            return 0.0;
        }
    }

}
