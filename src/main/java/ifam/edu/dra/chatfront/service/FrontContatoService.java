package ifam.edu.dra.chatfront.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
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

	public List<Contato> getContatos() {
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<Contato[]> response = restTemplate.getForEntity(backendUrl, Contato[].class);
		return new ArrayList<Contato>(Arrays.asList(response.getBody()));
	}

	public Contato getContato(Long id) {
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<Contato> response = restTemplate.getForEntity(backendUrl + "/" + id.toString(), Contato.class);
		return response.getBody();
	}

	public Contato postContato(Contato contato) {
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Contato> requestBody = new HttpEntity<>(contato, headers);

		ResponseEntity<Contato> response = restTemplate.postForEntity(backendUrl, requestBody, Contato.class);

		return response.getBody();
	}

	public Contato putContato(Long id, Contato contato) {
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Contato> requestBody = new HttpEntity<>(contato, headers);

		String url = backendUrl + "/" + Long.toString(id);
		ResponseEntity<Contato> response = restTemplate.exchange(url, HttpMethod.PUT, requestBody, Contato.class);
		return response.getBody();
	}

	public void deleteContato(Long id) {
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Contato> requestBody = new HttpEntity<>(new Contato(), headers);

		String url = backendUrl + "/" + Long.toString(id);
		ResponseEntity<Contato> response = restTemplate.exchange(url, HttpMethod.DELETE, requestBody, Contato.class);
	}
}