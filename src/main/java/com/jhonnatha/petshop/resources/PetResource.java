package com.jhonnatha.petshop.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jhonnatha.petshop.domain.Pet;
import com.jhonnatha.petshop.dto.PetDTO;
import com.jhonnatha.petshop.service.PetService;

@RestController
@RequestMapping(value = "/pets")
public class PetResource {
	
	@Autowired
	PetService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {		
		Pet obj = service.find(id);		
		return ResponseEntity.ok().body(obj);
	}
	

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> insert(@RequestBody Pet obj) {			
		obj = service.insert(obj);		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Pet obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = service.update(obj);		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {				
		service.delete(id);		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PetDTO>> findAll() {
		List<Pet> list = service.findAll();
		List<PetDTO> listDto = list.stream().map(obj -> new PetDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

}
