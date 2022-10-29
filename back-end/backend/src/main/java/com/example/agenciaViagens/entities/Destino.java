package com.example.agenciaViagens.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "destinos")
public class Destino {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	

	private String nome;
	
	private String estado;
	
	private String pais;
	
	private String dataIda;
	
	private String dataVolta;

	private float valor;
	
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "destino")
	private List<Promocao> promocoes = new ArrayList<Promocao>();

	
	
	public List<Promocao> getPromocoes() {
		return promocoes;
	}

	public void setPromocoes(List<Promocao> promocoes) {
		this.promocoes = promocoes;
	}
	
	

	public Destino() {
		super();
	}
	
	

	public Destino(int id, String nome, String estado, String pais, String dataIda, String dataVolta, float valor) {
		super();
		this.id = id;
		this.nome = nome;
		this.estado = estado;
		this.pais = pais;
		this.dataIda = dataIda;
		this.dataVolta = dataVolta;
		this.valor = valor;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getDataIda() {
		return dataIda;
	}

	public void setDataIda(String dataIda) {
		this.dataIda = dataIda;
	}

	public String getDataVolta() {
		return dataVolta;
	}

	public void setDataVolta(String dataVolta) {
		this.dataVolta = dataVolta;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
	
}