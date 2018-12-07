package br.com.agenda.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Agendamento {
	
	@Id
	@NotBlank(message = "O Nome do cliente é obrigatório")
	private String nomeCliente;
		
	@NotBlank(message = "O procesimento agendado é obrigatório")
	private String procedimento; 
	
	@NotBlank(message = "teste")
	@DateTimeFormat(pattern="dd-mm-yyyy")
	private String data;
	
	@NotBlank(message = "Texto é obrigatório")
	private String descricao;
	
	private String resumo;

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getProcedimento() {
		return procedimento;
	}

	public void setProcedimento(String procedimento) {
		this.procedimento = procedimento;
	}
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

}
