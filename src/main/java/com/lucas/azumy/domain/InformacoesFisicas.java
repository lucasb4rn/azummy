package com.lucas.azumy.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InformacoesFisicas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private double altura;
	private double peso;
	private double medida1;
	private double medida2;
	private double medida3;
	private double medida4;
	private double medida5;
	private double medida6;
	private double medida7;

	public InformacoesFisicas(Integer id, double altura, double peso, double medida1, double medida2, double medida3,
			double medida4, double medida5, double medida6, double medida7) {
		super();
		this.id = id;
		this.altura = altura;
		this.peso = peso;
		this.medida1 = medida1;
		this.medida2 = medida2;
		this.medida3 = medida3;
		this.medida4 = medida4;
		this.medida5 = medida5;
		this.medida6 = medida6;
		this.medida7 = medida7;
	}
	
	public InformacoesFisicas(double altura, double peso, double medida1, double medida2, double medida3,
			double medida4, double medida5, double medida6, double medida7) {
		this.altura = altura;
		this.peso = peso;
		this.medida1 = medida1;
		this.medida2 = medida2;
		this.medida3 = medida3;
		this.medida4 = medida4;
		this.medida5 = medida5;
		this.medida6 = medida6;
		this.medida7 = medida7;
	}


	public InformacoesFisicas() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getMedida1() {
		return medida1;
	}

	public void setMedida1(double medida1) {
		this.medida1 = medida1;
	}

	public double getMedida2() {
		return medida2;
	}

	public void setMedida2(double medida2) {
		this.medida2 = medida2;
	}

	public double getMedida3() {
		return medida3;
	}

	public void setMedida3(double medida3) {
		this.medida3 = medida3;
	}

	public double getMedida4() {
		return medida4;
	}

	public void setMedida4(double medida4) {
		this.medida4 = medida4;
	}

	public double getMedida5() {
		return medida5;
	}

	public void setMedida5(double medida5) {
		this.medida5 = medida5;
	}

	public double getMedida6() {
		return medida6;
	}

	public void setMedida6(double medida6) {
		this.medida6 = medida6;
	}

	public double getMedida7() {
		return medida7;
	}

	public void setMedida7(double medida7) {
		this.medida7 = medida7;
	}

}
