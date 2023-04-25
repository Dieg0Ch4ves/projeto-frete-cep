package com.projetofrete.projetoFreteCep.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.projetofrete.projetoFreteCep.cep.Cep;

@Service
public class CepService {
	private RestTemplate restTemplate = new RestTemplate();

	public Map<String, String> buscarCep(String cep) {
		String url = "https://viacep.com.br/ws/" + cep + "/json/";
		ResponseEntity<Map> resposta = restTemplate.getForEntity(url, Map.class);
		Map<String, String> resultado = resposta.getBody();
		return resultado;
	}
}
