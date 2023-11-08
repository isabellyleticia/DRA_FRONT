package ifam.edu.dra.chatfront.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class Contato {

	private Long id;

	@NotBlank(message = "O campo do Nome não deve ficar vazio!")
	private String nome;
	@Email(message = "Digite um email válido")
	private String email;
	@NotBlank(message = "O campo do Telefone não deve ficar vazio!")
	private String telefone;
	@NotBlank(message = "O campo do Endereço não deve ficar vazio!")
	private String endereco;
	@NotBlank(message = "O campo do Bairro não deve ficar vazio!")
	private String bairro;
	@NotBlank(message = "O campo do Cidade não deve ficar vazio!")
	private String cidade;
	@NotBlank(message = "O campo do Estado não deve ficar vazio!")
	private String estado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Contato [id=" + id + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", endereco="
				+ endereco + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + "]";
	}
}