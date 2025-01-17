package br.com.isaac.previsaodotempo.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Localizacao(@JsonAlias("name") String cidade,
                          @JsonAlias("country") String pais) {

}
