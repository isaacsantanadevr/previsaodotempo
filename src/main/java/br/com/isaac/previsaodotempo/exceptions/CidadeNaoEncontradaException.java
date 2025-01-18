package br.com.isaac.previsaodotempo.exceptions;

public class CidadeNaoEncontradaException extends RuntimeException{
    public CidadeNaoEncontradaException(String mensagem){
        throw new CidadeNaoEncontradaException("Cidade não encontrada, digite novamente!");
    }
}
