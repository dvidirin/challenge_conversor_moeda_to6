import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class CurrencyConverter {

    public double converterMoeda(String baseCode, String targetCode, double amount){
        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/88518e649910e8abed43d9d8/pair/" + baseCode + "/" + targetCode + "/" + amount);
        
        HttpRequest request = HttpRequest.newBuilder()
            .uri(endereco)
            .build();
        
        try {
            HttpResponse<String> response = HttpClient
                .newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());
            
            // Parse do JSON
            JsonElement jsonElement = JsonParser.parseString(response.body());
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            
            // Extrair o valor do campo conversion_result
            double conversionResult = jsonObject.get("conversion_result").getAsDouble();
            
            return conversionResult;
        } catch (Exception e) {
            throw new RuntimeException("Unable to get conversion value.");
        }
    }
}