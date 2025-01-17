package br.com.isaac.previsaodotempo.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TempoAtual(@JsonAlias("temp_c") double tempCelsius,
                         @JsonAlias("feelslike_c") double sensacaoTermica,
                         @JsonAlias("humidity") int umidade) {

}
