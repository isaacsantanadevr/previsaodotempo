package br.com.isaac.previsaodotempo.service;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ConsumoApiService {

    private HttpClient client = HttpClient.newHttpClient();
    private String url = "https://api.weatherapi.com/v1/current.json"; 
    @Value("${api.key}")
    private String apiKey; 

    public String buscaTempoCidade(String cidade) throws IOException, InterruptedException{
        cidade = URLEncoder.encode(cidade.trim(), StandardCharsets.UTF_8);
        String endereco = String.format("%s?key=%s&q=%s", url, apiKey, cidade); 

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build();

        //Funcionamento anterior
        //HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        //Tratamento de Exceções
        try {
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            return response.body();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

}
