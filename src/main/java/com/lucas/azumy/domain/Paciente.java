package com.lucas.azumy.domain;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
public class Paciente {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer id;
	private String nome;
	private String cpf;
	private String rg;

	@Enumerated
	private Sexo sexo;
	private Date dataNascimento;

	@OneToOne(cascade = CascadeType.PERSIST)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Contato contato;

	@OneToOne(cascade = CascadeType.PERSIST)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Endereco endereco;

	public Paciente(String nome, String cpf, String rg, Sexo sexo, Date dataNascimento, Contato contato,
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

	public Paciente(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Integer getIdade() {
		GregorianCalendar hj = new GregorianCalendar();
		GregorianCalendar nascimento = new GregorianCalendar();
		if (dataNascimento != null) {
			nascimento.setTime(dataNascimento);
		}
		int anohj = hj.get(Calendar.YEAR);
		int anoNascimento = nascimento.get(Calendar.YEAR);
		return anohj - anoNascimento;
	}

	public Paciente() {
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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
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
