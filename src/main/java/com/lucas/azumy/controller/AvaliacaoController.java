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

import com.lucas.azumy.domain.Avaliacao;
import com.lucas.azumy.dtos.AvaliacaoDTO;
import com.lucas.azumy.service.AvaliacaoService;
import com.lucas.azumy.service.InformacoesFisicasService;
import com.lucas.azumy.service.PacienteService;
import com.lucas.azumy.service.ProfissionalService;
import com.lucas.azumy.service.ResultadoAvaliacaoService;

@CrossOrigin(origins = "*", maxAge = 4800)
@RestController
@RequestMapping(value = "/avaliacao")
public class AvaliacaoController {

	
	@Autowired
	private AvaliacaoService service;
	@Autowired
	private ProfissionalService profissionalService;
	@Autowired
	private PacienteService pacienteService;
	@Autowired
	private InformacoesFisicasService informacoesFisicasService;
	@Autowired
	private ResultadoAvaliacaoService resultadoAvaliacaoServiceService;;

// Funcionando	
	@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Avaliacao> findById(@PathVariable Integer id) {
		Avaliacao obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	// Funcionando	
	@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
	@GetMapping
	public ResponseEntity<List<Avaliacao>> findAll() {
		List<Avaliacao> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}

	// Funcionando	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	public ResponseEntity<Avaliacao> create(@Valid @RequestBody AvaliacaoDTO obj) {
		Avaliacao objNew = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path(("/{id}")).buildAndExpand(objNew.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	// Funcionando	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping(value = "/{id}")
	public ResponseEntity<Avaliacao> update(@PathVariable Integer id, @Valid @RequestBody Avaliacao obj) {
		Avaliacao newObj = service.update(obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
