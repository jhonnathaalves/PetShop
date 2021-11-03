package com.jhonnatha.petshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.jhonnatha.petshop.domain.Produto;
import com.jhonnatha.petshop.repository.ProdutoRepository;
import com.jhonnatha.petshop.resources.exceptions.DataIntegrityException;
import com.jhonnatha.petshop.service.exceptions.ObjetoNaoEncontradoException;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repo;

	public Produto find(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow( () -> new ObjetoNaoEncontradoException( "Objeto não encontrado. ID: " + id + ", Tipo: " + Produto.class.getName()));
	}
	

	public Produto insert(Produto obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Produto update(Produto obj) {
		find(obj.getId());
		return repo.save(obj);
	}	

	public void delete(Integer id) {
		find(id);		
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Produto não pode ser deletado!");
		}		
	}

	public List<Produto> findAll() {		
		return repo.findAll();
	}
	
}
