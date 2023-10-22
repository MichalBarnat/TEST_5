package zad2.service;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import zad2.model.OurClient;

@RequiredArgsConstructor
public class CurrencyService {

    private final OurClient client;

    public double exchange(double amount, String from, String to) {
        String json = client.getJson(amount, from, to);

        return parseJson(json);
    }

    public double exchange(double amount, String from, String to, String date) {
        String json = client.getJson(amount, from, to, date);

        return parseJson(json);
    }

    private double parseJson(String json) {
        double result = 0.0;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(json);
            result = jsonNode.get("result").asDouble();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return result;

    }


}
