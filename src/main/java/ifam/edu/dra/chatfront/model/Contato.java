package ifam.edu.dra.chatfront.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Contato(String nome, String email, String telefone, String endereco, String bairro, String cidade,
		String estado) {
	
}
