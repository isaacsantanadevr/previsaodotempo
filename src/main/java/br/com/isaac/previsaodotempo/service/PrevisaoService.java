package br.com.isaac.previsaodotempo.service;

import java.io.IOException;
    
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.isaac.previsaodotempo.model.TempoCidade;

@Service
public class PrevisaoService {

    private ConsumoApiService consumoApiService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public PrevisaoService(ConsumoApiService consumoApiService){
        this.consumoApiService = consumoApiService;
    }

    public TempoCidade buscaCidade(String cidade) throws InterruptedException{
        try {
            String json = consumoApiService.buscaTempoCidade(cidade);
            return objectMapper.readValue(json, TempoCidade.class);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao processar os dados da API: " + e.getMessage(), e);
        }
    }

}
