package com.br.senai.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name="Carro")
@Table(name="carros")
public class Carro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cdcarro")
	private Integer id;
	
	@Column(name="cdplaca")
	private String placa;
	
	@Column(name="modelo")
	private String modelo;
	
	@Column(name="marca")
	private String marca;
	
	@Column(name="cor")
	private String cor;
	
	@Column(name="ano")
	private Integer ano;
	
	@Column(name="quilometrage")
	private Integer quilometragem;
	
	@Column(name="estado")
	private String estado;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Integer getQuilometragem() {
		return quilometragem;
	}

	public void setQuilometragem(Integer quilometragem) {
		this.quilometragem = quilometragem;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Carro: "
				+ "ID: " + id 
				+ " Placa: " + placa 
				+ " Modelo: " + modelo 
				+ " Marca: " + marca 
				+ " Cor: " + cor
				+ " Ano: " + ano 
				+ " Quilometragem: " + quilometragem 
				+ " Estado: " + estado;
	}
	
	
}
