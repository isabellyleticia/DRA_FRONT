package ifam.edu.dra.chatfront.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ifam.edu.dra.chatfront.model.Contato;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FrontContatoService {

	private final String backendUrl = "http://localhost:8080/contato";
	private final RestTemplate restTemplate;

	public FrontContatoService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public List<Contato> getContatos() {
		String url = backendUrl;
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<Contato[]> response = restTemplate.getForEntity(url, Contato[].class);
		return new ArrayList<Contato>(Arrays.asList(response.getBody()));
	}

	public Contato getContato(Long id) {
		String url = backendUrl + id;
		return restTemplate.getForObject(url, Contato.class);
	}

	public Contato setContato(Contato contato) {
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Contato> requestBody = new HttpEntity<>(contato, headers);

		ResponseEntity<Contato> response = restTemplate.postForEntity(backendUrl, requestBody, Contato.class);

		return response.getBody();
	}

	public Contato updateContato(Long id, Contato contato) {
		String url = backendUrl + id;
		restTemplate.put(url, contato);
		return contato;
	}

	public void deleteContato(Long id) {
		String url = backendUrl + id;
		restTemplate.delete(url);
	}
}