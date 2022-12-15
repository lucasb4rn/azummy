package com.lucas.azumy.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Avaliacao {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer id;

	@OneToOne
	private Paciente paciente;

	@OneToOne
	private Profissional profissional;

	@OneToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private InformacoesFisicas informacaoesFisicas;
	@OneToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private ResultadoAvaliacao resultadoAvaliacao;
	private boolean isCortesia;

	public Avaliacao(Integer id, Paciente paciente, Profissional profissional, InformacoesFisicas informacaoesFisicas,
			ResultadoAvaliacao resultadoAvaliacao, boolean isCortesia) {
		super();
		this.id = id;
		this.paciente = paciente;
		this.profissional = profissional;
		this.informacaoesFisicas = informacaoesFisicas;
		this.resultadoAvaliacao = resultadoAvaliacao;
		this.isCortesia = isCortesia;
	}


	public Avaliacao() {
		super();
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	public InformacoesFisicas getInformacaoesFisicas() {
		return informacaoesFisicas;
	}

	public void setInformacaoesFisicas(InformacoesFisicas informacaoesFisicas) {
		this.informacaoesFisicas = informacaoesFisicas;
	}

	public ResultadoAvaliacao getResultadoAvaliacao() {
		return resultadoAvaliacao;
	}

	public void setResultadoAvaliacao(ResultadoAvaliacao resultadoAvaliacao) {
		this.resultadoAvaliacao = resultadoAvaliacao;
	}

	public boolean isCortesia() {
		return isCortesia;
	}

	public void setCortesia(boolean isCortesia) {
		this.isCortesia = isCortesia;
	}

}
