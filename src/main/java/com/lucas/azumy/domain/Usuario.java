package com.lucas.azumy.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.lucas.azumy.dtos.UsuarioDTO;
import com.lucas.azumy.enums.Perfil;
import com.lucas.azumy.service.ColaboradorService;

@Entity
@Table(name = "seg_usuario")

public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(nullable = false, unique = true)
	private String username;
	@Column(nullable = false)
	private String password;
	@OneToOne
	@NotNull
	@JoinColumn(name = "id_colaborador", unique = true)
	private Colaborador colaborador;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "PERFIS")
	protected Set<Integer> perfis = new HashSet<>();

	public Usuario(Integer id, String username, String password, Colaborador colaborador) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.colaborador = colaborador;
		addPerfil(Perfil.USER);
	}

	public Usuario(UsuarioDTO obj) {
		this.id = obj.getId();
		this.username = obj.getUsername();
		this.password = obj.getPassword();
		Colaborador col = new Colaborador();
		col.setId(obj.getColaborador());
		this.colaborador = col;
		this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
	}

	public void addPerfil(Perfil perfil) {
		this.perfis.add(perfil.getCodigo());
	}

	public Usuario() {
		addPerfil(Perfil.USER);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
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


	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void setPerfis(Set<Integer> perfis) {
		this.perfis = perfis;
	}

}
