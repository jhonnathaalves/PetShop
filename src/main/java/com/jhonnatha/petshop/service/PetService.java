package com.jhonnatha.petshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.jhonnatha.petshop.domain.Pet;
import com.jhonnatha.petshop.repository.PetRepository;
import com.jhonnatha.petshop.resources.exceptions.DataIntegrityException;
import com.jhonnatha.petshop.service.exceptions.ObjetoNaoEncontradoException;

@Service
public class PetService {
	
	@Autowired
	private PetRepository repo;

	public Pet find(Integer id) {
		Optional<Pet> obj = repo.findById(id);
		return obj.orElseThrow( () -> new ObjetoNaoEncontradoException( "Objeto não encontrado. ID: " + id + ", Tipo: " + Pet.class.getName()));
	}
	

	public Pet insert(Pet obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Pet update(Pet obj) {
		find(obj.getId());
		return repo.save(obj);
	}	

	public void delete(Integer id) {
		find(id);		
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Pet não pode ser deletado!");
		}		
	}

	public List<Pet> findAll() {		
		return repo.findAll();
	}
	
}
