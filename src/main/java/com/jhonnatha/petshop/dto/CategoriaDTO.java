package com.jhonnatha.petshop.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.jhonnatha.petshop.domain.Categoria;
import com.jhonnatha.petshop.domain.Produto;

public class CategoriaDTO implements Serializable { 
	
	private static final long serialVersionUID = 1L;

	private String nome;
	private List<Produto> produtos = new ArrayList<>();

	public CategoriaDTO() {

	}

	public CategoriaDTO(Categoria obj) {		
		this.setNome(obj.getNome());
		this.setProdutos(obj.getProdutos());
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}



}
