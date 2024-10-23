package br.edu.infnet.elberth.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TEletronico")
public class Eletronico extends Produto {
	private String marca;
	private int garantiaMeses;

	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getGarantiaMeses() {
		return garantiaMeses;
	}
	public void setGarantiaMeses(int garantiaMeses) {
		this.garantiaMeses = garantiaMeses;
	}
}
