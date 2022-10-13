package com.lucas.azumy.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.lucas.azumy.domain.Profissional;
import com.lucas.azumy.service.ProfissionalService;

@CrossOrigin(origins = "*", maxAge = 4800)
@RestController
@RequestMapping(value = "/profissional")
public class ProfissionalController {

	@Autowired
	private ProfissionalService profissionalService;

// Funcionando	
//	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Profissional> findById(@PathVariable Integer id) {
		Profissional obj = profissionalService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	
	// Funcionando	
//	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	@GetMapping
	public ResponseEntity<List<Profissional>> findAll() {
		List<Profissional> lista = profissionalService.findAll();
		return ResponseEntity.ok().body(lista);
	}

	
	
	
	// Funcionando	
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping
	public ResponseEntity<Profissional> create(@Valid @RequestBody Profissional obj) {
		obj = profissionalService.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path(("/{id}")).buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	
	
	// Funcionando	
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping(value = "/{id}")
	public ResponseEntity<Profissional> update(@PathVariable Integer id, @Valid @RequestBody Profissional objDTO) {
		Profissional newObj = profissionalService.update(id, objDTO);
		return ResponseEntity.ok().body(newObj);
	}
	
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		profissionalService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
