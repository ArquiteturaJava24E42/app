package br.edu.infnet.elberth.model.domain;

public class Alimenticio extends Produto {
	private boolean organico;
	private String caracteristica;

	public boolean isOrganico() {
		return organico;
	}
	public void setOrganico(boolean organico) {
		this.organico = organico;
	}
	public String getCaracteristica() {
		return caracteristica;
	}
	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}
}