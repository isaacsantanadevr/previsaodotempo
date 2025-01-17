package br.com.isaac.previsaodotempo.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TempoCidade(@JsonAlias("location") Localizacao localizacao,
                          @JsonAlias("current") TempoAtual tempoAtual){

}
