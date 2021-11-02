package com.jhonnatha.petshop.dto;

import java.io.Serializable;

import com.jhonnatha.petshop.domain.Servico;

public class ServicoDTO implements Serializable { 
	
	private static final long serialVersionUID = 1L;

	private String descricao;
	
	public ServicoDTO() {

	}
	
	public ServicoDTO(Servico obj) {		
		this.descricao = obj.getDescricao();
		
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


}
