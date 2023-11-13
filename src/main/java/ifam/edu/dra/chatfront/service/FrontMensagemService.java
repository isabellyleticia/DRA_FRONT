package ifam.edu.dra.chatfront.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ifam.edu.dra.chatfront.model.Mensagem;

@Service
public class FrontMensagemService {

	private final String backendUrl = "http://localhost:8080/mensagem";

	public List<Mensagem> getMensagens() {
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<Mensagem[]> response = restTemplate.getForEntity(backendUrl, Mensagem[].class);
		return new ArrayList<Mensagem>(Arrays.asList(response.getBody()));
	}
	
	public Mensagem postMensagem(Mensagem mensagem) {
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Mensagem> requestBody = new HttpEntity<>(mensagem, headers);

		ResponseEntity<Mensagem> response = restTemplate.postForEntity(backendUrl, requestBody, Mensagem.class);

		return response.getBody();
	}
}
