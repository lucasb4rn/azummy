package com.lucas.azumy.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.lucas.azumy.domain.Paciente;
import com.lucas.azumy.domain.Profissional;
import com.lucas.azumy.dtos.ProfissionalDTO;
import com.lucas.azumy.service.PacienteService;

@CrossOrigin(origins = "*", maxAge = 4800)
@RestController
@RequestMapping(value = "/paciente")
public class PacienteController {

	@Autowired
	private PacienteService pacienteService;

// Funcionando	
	@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Paciente> findById(@PathVariable Integer id) {
		Paciente obj = pacienteService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	// Funcionando	
	@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
	@GetMapping
	public ResponseEntity<List<Paciente>> findAll() {
		List<Paciente> lista = pacienteService.findAll();
		return ResponseEntity.ok().body(lista);
	}

	
	// Funcionando	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	public ResponseEntity<Paciente> create(@Valid @RequestBody Paciente obj) throws Exception {
		obj = pacienteService.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path(("/{id}")).buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	
	// Funcionando	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping(value = "/{id}")
	public ResponseEntity<Paciente> update(@PathVariable Integer id, @Valid @RequestBody Paciente paciente) {
		Paciente newObj = pacienteService.update(paciente);
		return ResponseEntity.ok().body(newObj);
	}
	
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Paciente> delete(@PathVariable Integer id) {
		pacienteService.delete(id); 
		return ResponseEntity.noContent().build();
	}
	
	
	
}
