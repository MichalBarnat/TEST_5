package zad2.model;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class OurClient {
    private static String URL = "https://api.apilayer.com/exchangerates_data/";
    private static String API = "TMrs25g3tBZe2qvKJNgMqcQOMNAQe1Md";

    public String getJson(double amount, String from, String to) {
        String url = URL + "convert?amount=" + amount + "&from=" + from + "&to=" + to;

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .addHeader("apiKey", API)
                .build();

        String json = "";

        try {
            Response response = client.newCall(request).execute();
            json = response.body().string();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return json;
    }

    public String getJson(double amount, String from, String to, String date) {
        String url = URL + "convert?amount=" + amount + "&from=" + from + "&to=" + to + "&date=" + date;

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .addHeader("apiKey", API)
                .build();

        String json = "";

        try {
            Response response = client.newCall(request).execute();
            json = response.body().string();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return json;
    }

}
