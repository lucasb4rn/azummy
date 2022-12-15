package com.lucas.azumy.dtos;

import com.lucas.azumy.domain.InformacoesFisicas;
import com.lucas.azumy.domain.ResultadoAvaliacao;

public class AvaliacaoDTO {

	private Integer id;
	private Integer paciente;
	private Integer profissional;
	private InformacoesFisicas informacoesFisicas;
	private ResultadoAvaliacao resultadoAvaliacao;

	public AvaliacaoDTO(Integer id, Integer paciente, Integer profissional, InformacoesFisicas informacoesFisicas,
			ResultadoAvaliacao resultadoAvaliacao) {
		this.id = id;
		this.paciente = paciente;
		this.profissional = profissional;
		this.informacoesFisicas = informacoesFisicas;
		this.resultadoAvaliacao = resultadoAvaliacao;
	}

	public AvaliacaoDTO() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPaciente() {
		return paciente;
	}

	public void setPaciente(Integer paciente) {
		this.paciente = paciente;
	}

	public Integer getProfissional() {
		return profissional;
	}

	public void setProfissional(Integer profissional) {
		this.profissional = profissional;
	}

	public InformacoesFisicas getInformacoesFisicas() {
		return informacoesFisicas;
	}

	public void setInformacoesFisicas(InformacoesFisicas informacoesFisicas) {
		this.informacoesFisicas = informacoesFisicas;
	}

	public ResultadoAvaliacao getResultadoAvaliacao() {
		return resultadoAvaliacao;
	}

	public void setResultadoAvaliacao(ResultadoAvaliacao resultadoAvaliacao) {
		this.resultadoAvaliacao = resultadoAvaliacao;
	}

}
