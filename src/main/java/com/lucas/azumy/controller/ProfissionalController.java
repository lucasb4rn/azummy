package com.lucas.azumy.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

import com.lucas.azumy.domain.Colaborador;
import com.lucas.azumy.domain.Profissional;
import com.lucas.azumy.dtos.ProfissionalDTO;
import com.lucas.azumy.service.ColaboradorService;
import com.lucas.azumy.service.ProfissionalService;
import com.lucas.azumy.service.exception.DataIntegrityViolationException;

@CrossOrigin(origins = "*", maxAge = 4800)
@RestController
@RequestMapping(value = "/profissional")
public class ProfissionalController {

	@Autowired
	private ProfissionalService profissionalService;
	
	private ColaboradorService colaboradorService;

// Funcionando	
	@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Profissional> findById(@PathVariable Integer id) {
		Profissional obj = profissionalService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	
	// Funcionando	
	@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
	@GetMapping
	public ResponseEntity<List<Profissional>> findAll() {
		List<Profissional> lista = profissionalService.findAll();
		return ResponseEntity.ok().body(lista);
	}

	
	
	
	// Funcionando	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	public ResponseEntity<ProfissionalDTO> create(@Valid @RequestBody ProfissionalDTO obj) {
		
		Profissional objNew = profissionalService.create(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path(("/{id}")).buildAndExpand(objNew.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	
	
	// Funcionando	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping(value = "/{id}")
	public ResponseEntity<Profissional> update(@PathVariable Integer id, @Valid @RequestBody ProfissionalDTO objDTO) {
		Profissional newObj = profissionalService.update(objDTO);
		return ResponseEntity.ok().body(newObj);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		profissionalService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
