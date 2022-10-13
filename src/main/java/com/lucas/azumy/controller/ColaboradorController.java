package com.lucas.azumy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.azumy.domain.Colaborador;
import com.lucas.azumy.service.ColaboradorService;

@CrossOrigin(origins = "*", maxAge = 4800)
@RestController
@RequestMapping(value = "/colaborador")
public class ColaboradorController {

	@Autowired
	private ColaboradorService colaboradorService;

// Funcionando	
//	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Colaborador> findById(@PathVariable Integer id) {
		Colaborador obj = colaboradorService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	// Funcionando	
//	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	@GetMapping
	public ResponseEntity<List<Colaborador>> findAll() {
		List<Colaborador> lista = colaboradorService.findAll();
		return ResponseEntity.ok().body(lista);
	}

	
	
}
