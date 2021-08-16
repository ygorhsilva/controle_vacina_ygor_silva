package br.com.opta2.vacina.enums;

public enum Vacina {
	ATRAZENECA("Astrazeneca"),
	CORONAVAC("Coronavac"),
	PFIZER("Pfizer");
	private String descricao;
	private Vacina(String descricao) {
		this.descricao = descricao;
	}
	public String getDescricao() {
		return descricao;
	}
}
