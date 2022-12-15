package com.lucas.azumy.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Endereco {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer id;
	private String cep;
	private String endereco;
	private String cidade;
	private String uf;
	private String pais;

	public Endereco(String cep, String endereco, String cidade, String uf, String pais) {
		this.cep = cep;
		this.endereco = endereco;
		this.cidade = cidade;
		this.uf = uf;
		this.pais = pais;
	}
	
	public Endereco() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

}