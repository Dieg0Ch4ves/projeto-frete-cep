package com.projetofrete.projetoFreteCep.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetofrete.projetoFreteCep.cep.Cep;
import com.projetofrete.projetoFreteCep.service.CepService;

@RestController
@RequestMapping("/cep")
public class novoCep {

	@Autowired
	private CepService cepService;

	@GetMapping("/{cep}")
	public ResponseEntity<Cep> buscarCep(@PathVariable String cep) {
		Map<String, String> resultado = cepService.buscarCep(cep);
		Cep cep1 = new Cep(resultado.get("cep"), resultado.get("logradouro"), resultado.get("complemento"),
				resultado.get("bairro"), resultado.get("localidade"), resultado.get("uf"));
		cep1.setFrete(calcularFrete(resultado.get("uf")));	
		return new ResponseEntity<>(cep1, HttpStatus.OK);
	}
	
	private double calcularFrete(String uf) {
        switch (uf) {
            case "SP":
            case "RJ":
            case "MG":
                return 7.85;
            case "PR":
            case "SC":
            case "RS":
                return 17.50;
            case "BA":
            case "SE":
            case "AL":
            case "PE":
            case "PB":
            case "RN":
            case "CE":
            case "PI":
            case "MA":
                return 15.98;
            case "MT":
            case "MS":
            case "DF":
            	return 12.50;
            case "AC":
            case "AP":
            case "AM":
            case "PA":
            case "RO":
            case "RR":
            case "TO":
            	return 20.83;
            default:
                return 30.0;
        }
	}
}