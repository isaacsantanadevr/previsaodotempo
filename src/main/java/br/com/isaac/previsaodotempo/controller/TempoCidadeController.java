package br.com.isaac.previsaodotempo.controller;

import br.com.isaac.previsaodotempo.dto.PrevisaoDTO;
import br.com.isaac.previsaodotempo.exceptions.CidadeNaoEncontradaException;
import br.com.isaac.previsaodotempo.model.TempoCidade;
import br.com.isaac.previsaodotempo.service.PrevisaoService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TempoCidadeController {

    private PrevisaoService previsaoService;

    public TempoCidadeController(PrevisaoService previsaoService){
        this.previsaoService = previsaoService;
    }

    @GetMapping("/")
    public String paginaInicial(){
        return "index";
    }

    @GetMapping("/previsao")
    public String getPrevisao(@RequestParam String cidade, Model model) throws InterruptedException {
        try {
            TempoCidade tempoCidade = previsaoService.buscaCidade(cidade);
            PrevisaoDTO previsaoDTO = new PrevisaoDTO(tempoCidade.localizacao(), tempoCidade.tempoAtual());

            model.addAttribute("previsao", previsaoDTO);

            return "previsao";
        } catch (CidadeNaoEncontradaException e) {
            model.addAttribute("erro", "Cidade não encontrada! Verifique os dados!");
        } catch (Exception e){
            model.addAttribute("erro", "Erro inesperado: " + e.getMessage());
        }
        return "previsao";
    }
    
}
