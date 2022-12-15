package com.lucas.azumy.dtos;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import com.lucas.azumy.domain.Usuario;
import com.lucas.azumy.enums.Perfil;

public class UsuarioDTO {

	private Integer id;
	@NotNull(message = "O campo username é requerido")
	private String username;
	@NotNull(message = "O campo password é requerido")
	private String password;
	@NotNull(message = "O campo Colaborador é requerido")
	private Integer colaborador;
	@NotNull
	protected Set<Integer> perfis = new HashSet<>();

	public UsuarioDTO(Integer id, @NotNull(message = "O campo username é requerido") String username,
			@NotNull(message = "O campo password é requerido") String password,
			@NotNull(message = "O campo Colaborador é requerido") Integer colaborador, @NotNull Set<Integer> perfis) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.colaborador = colaborador;
		this.perfis = getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());;
	}

	public UsuarioDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.username = usuario.getUsername();
		this.password = usuario.getPassword();
		this.colaborador = usuario.getColaborador().getId();
		this.perfis = usuario.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		addPerfil(Perfil.USER);
	}

	public UsuarioDTO() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getColaborador() {
		return colaborador;
	}

	public void setColaborador(Integer colaborador) {
		this.colaborador = colaborador;
	}

	public void addPerfil(Perfil perfil) {
		this.perfis.add(perfil.getCodigo());
	}
	
	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void setPerfis(Set<Integer> perfis) {
		this.perfis = perfis;
	}

}
