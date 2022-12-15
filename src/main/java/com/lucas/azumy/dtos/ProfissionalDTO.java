package com.lucas.azumy.dtos;

import javax.validation.constraints.NotNull;

import com.lucas.azumy.domain.Profissional;

public class ProfissionalDTO {

	private Integer id;
	@NotNull(message = "O campo nome é requerido")
	private String nome;
	@NotNull(message = "O campo Colaborador é requerido")
	private Integer colaborador;

	public ProfissionalDTO(Profissional profissional) {
		this.id = profissional.getId();
		this.nome = profissional.getNome();
		this.colaborador = profissional.getColaborador().getId();
	}

	public ProfissionalDTO() {
		super();
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

	public Integer getColaborador() {
		return colaborador;
	}

	public void setColaborador(Integer colaborador) {
		this.colaborador = colaborador;
	}

}
