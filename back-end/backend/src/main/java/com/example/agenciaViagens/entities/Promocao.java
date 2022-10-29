package com.example.agenciaViagens.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "promocoes")
public class Promocao {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	
	private float valorPromo;

	
	@ManyToOne
	@JoinColumn(name = "destino_fk")
	private Destino destino;

	
	public Promocao() {
		super();
	}





	public Promocao(int id, String nome, float valorPromo) {
		super();
		this.id = id;
		this.nome = nome;
		this.valorPromo = valorPromo;
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





	public float getValorPromon() {
		return valorPromo;
	}





	public void setValorPromo(float valorPromo) {
		this.valorPromo = valorPromo;
	}





	public Destino getDestino() {
		return destino;
	}





	public void setDestino(Destino destino) {
		this.destino = destino;
	}
	
	
	
	
	
	
	
	
}