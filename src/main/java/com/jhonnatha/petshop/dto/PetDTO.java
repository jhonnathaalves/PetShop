package com.jhonnatha.petshop.dto;

import java.io.Serializable;

import com.jhonnatha.petshop.domain.Especie;
import com.jhonnatha.petshop.domain.Pet;
import com.jhonnatha.petshop.domain.Raca;

public class PetDTO implements Serializable { 
	
	private static final long serialVersionUID = 1L;

	private String nome;
	private Integer idade;
	private Especie especie;
	private Raca raca;
	

	public PetDTO() {

	}

	public PetDTO(Pet obj) {		
		this.nome = obj.getNome();
		this.idade = obj.getIdade();
		this.especie = obj.getEspecie();
		this.raca = obj.getRaca();
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Especie getEspecie() {
		return especie;
	}

	public void setEspecie(Especie especie) {
		this.especie = especie;
	}

	public Raca getRaca() {
		return raca;
	}

	public void setRaca(Raca raca) {
		this.raca = raca;
	}




}
