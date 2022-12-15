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
import com.lucas.azumy.service.ColaboradorService;
import com.lucas.azumy.service.InformacoesFisicasService;
import com.lucas.azumy.service.PacienteService;
import com.lucas.azumy.service.ProfissionalService;
import com.lucas.azumy.service.ResultadoAvaliacaoService;

@CrossOrigin(origins = "*", maxAge = 4800)
@RestController
@RequestMapping(value = "/colaborador")
public class ColaboradorController {

	@Autowired
	private ColaboradorService colaboradorService;

// Funcionando	
	@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Colaborador> findById(@PathVariable Integer id) {
		Colaborador obj = colaboradorService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	// Funcionando	
	@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
	@GetMapping
	public ResponseEntity<List<Colaborador>> findAll() {
		List<Colaborador> lista = colaboradorService.findAll();
		return ResponseEntity.ok().body(lista);
	}

	
	// Funcionando	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	public ResponseEntity<Colaborador> create(@Valid @RequestBody Colaborador obj) {
		obj = colaboradorService.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path(("/{id}")).buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	// Funcionando	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping(value = "/{id}")
	public ResponseEntity<Colaborador> update(@PathVariable Integer id, @Valid @RequestBody Colaborador colaborador) {
		Colaborador newObj = colaboradorService.update(colaborador);
		return ResponseEntity.ok().body(newObj);
	}
	
	
	
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Colaborador> delete(@PathVariable Integer id) {
		colaboradorService.delete(id); 
		return ResponseEntity.noContent().build();
	}
	
	
	
}
