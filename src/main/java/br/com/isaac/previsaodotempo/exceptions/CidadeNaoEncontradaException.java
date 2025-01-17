package br.com.isaac.previsaodotempo.exceptions;


public class CidadeNaoEncontradaException extends RuntimeException{
    public CidadeNaoEncontradaException(String mensagem){
        super(mensagem);
    }
}
