package com.lucas.azumy.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ResultadoAvaliacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private double imc;
	private double indiceGorduras;

	public ResultadoAvaliacao(Integer id, double imc, double indiceGorduras) {
		super();
		this.id = id;
		this.imc = imc;
		this.indiceGorduras = indiceGorduras;
	}

	public ResultadoAvaliacao() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getImc() {
		return imc;
	}

	public void setImc(double imc) {
		this.imc = imc;
	}

	public double getIndiceGorduras() {
		return indiceGorduras;
	}

	public void setIndiceGorduras(double indiceGorduras) {
		this.indiceGorduras = indiceGorduras;
	}

}