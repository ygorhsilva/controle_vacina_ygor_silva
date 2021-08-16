package br.com.opta2.vacina.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.opta2.vacina.enums.Uf;
import br.com.opta2.vacina.enums.Vacina;

@Entity
public class Vacinacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeDoVacinado;
	private Integer cpf;
	private Uf uf;
	private String cidade;
	private String dataDeAplicacao;
	private Vacina vacina;
	private String nomeDoResponsavelDeAplicacao;
	private String dataProvavelSegundaDose;
	
	public Vacinacao() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeDoVacinado() {
		return nomeDoVacinado;
	}

	public void setNomeDoVacinado(String nomeDoVacinado) {
		this.nomeDoVacinado = nomeDoVacinado;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	public Uf getUf() {
		return uf;
	}

	public void setUf(Uf uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getDataDeAplicacao() {
		return dataDeAplicacao;
	}

	public void setDataDeAplicacao(String dataDeAplicacao) {
		this.dataDeAplicacao = dataDeAplicacao;
	}

	public Vacina getVacina() {
		return vacina;
	}

	public void setVacina(Vacina vacina) {
		this.vacina = vacina;
	}

	public String getNomeDoResponsavelDeAplicacao() {
		return nomeDoResponsavelDeAplicacao;
	}

	public void setNomeDoResponsavelDeAplicacao(String nomeDoResponsavelDeAplicacao) {
		this.nomeDoResponsavelDeAplicacao = nomeDoResponsavelDeAplicacao;
	}

	public String getDataProvavelSegundaDose() {
		return dataProvavelSegundaDose;
	}

	public void setDataProvavelSegundaDose(String dataProvavelSegundaDose) {
		this.dataProvavelSegundaDose = dataProvavelSegundaDose;
	}
	
	
}
