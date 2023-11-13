package ifam.edu.dra.chatfront.model;

import java.util.Calendar;

import jakarta.validation.constraints.NotBlank;

public class Mensagem {

	private Long id;

	@NotBlank(message = "O campo Data e Hora não deve ficar vazio!")
	private Calendar datahora;
	@NotBlank(message = "O campo do Conteúdo não deve ficar vazio!")
	private String conteudo;
	@NotBlank(message = "O campo do Emissor não deve ficar vazio!")
	private Contato emissor;
	@NotBlank(message = "O campo do Receptor não deve ficar vazio!")
	private Contato receptor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getDatahora() {
		return datahora;
	}

	public void setDatahora(Calendar datahora) {
		this.datahora = datahora;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Contato getEmissor() {
		return emissor;
	}

	public void setEmissor(Contato emissor) {
		this.emissor = emissor;
	}

	public Contato getReceptor() {
		return receptor;
	}

	public void setReceptor(Contato receptor) {
		this.receptor = receptor;
	}

	@Override
	public String toString() {
		return "Mensagem [id=" + id + ", datahora=" + datahora + ", conteudo=" + conteudo + ", emissor=" + emissor
				+ ", receptor=" + receptor + "]";
	}
}
