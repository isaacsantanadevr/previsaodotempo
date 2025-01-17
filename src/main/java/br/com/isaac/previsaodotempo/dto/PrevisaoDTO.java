package br.com.isaac.previsaodotempo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.isaac.previsaodotempo.model.Localizacao;
import br.com.isaac.previsaodotempo.model.TempoAtual;

public class PrevisaoDTO {

    private String cidade;
    private String pais;
    private double tempCelsius;
    private double sensacaoTermica;
    private int umidade;

    @JsonProperty("localizacao")
    private Localizacao localizacao;
    @JsonProperty("tempoAtual")
    private TempoAtual tempoAtual;
    
    public PrevisaoDTO(){

    }

    public PrevisaoDTO(Localizacao localizacao, TempoAtual tempoAtual) {
        this.localizacao = localizacao;
        this.tempoAtual = tempoAtual;
        this.cidade = localizacao.cidade();
        this.pais = localizacao.pais();
        this.tempCelsius = tempoAtual.tempCelsius();
        this.sensacaoTermica = tempoAtual.sensacaoTermica();
        this.umidade = tempoAtual.umidade();
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public double getTempCelsius() {
        return tempCelsius;
    }

    public void setTempCelsius(double tempCelsius) {
        this.tempCelsius = tempCelsius;
    }

    public double getSensacaoTermica() {
        return sensacaoTermica;
    }

    public void setSensacaoTermica(double sensacaoTermica) {
        this.sensacaoTermica = sensacaoTermica;
    }

    public int getUmidade() {
        return umidade;
    }

    public void setUmidade(int umidade) {
        this.umidade = umidade;
    }

    
}
