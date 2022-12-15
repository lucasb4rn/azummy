package com.lucas.azumy.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Colaborador {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer id;
	private String nome;
	@NotNull
	@Column(unique = true)
	private String cpf;
	@NotNull
	private String rg;
	
	@Enumerated
	private Sexo sexo;
	
	@NotNull
	private String dataNascimento;

	@OneToOne
	@NotNull
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Contato contato;

	@OneToOne
	@NotNull
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Endereco endereco;

	public Colaborador(String nome, String cpf, String rg, Sexo sexo, String dataNascimento, Contato contato,
			Endereco endereco) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.contato = contato;
		this.endereco = endereco;
	}

	public Colaborador(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Colaborador() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
