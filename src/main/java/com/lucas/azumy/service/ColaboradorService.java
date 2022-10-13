package com.lucas.azumy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.azumy.domain.Colaborador;
import com.lucas.azumy.repositoies.ColaboradorRepository;
import com.lucas.azumy.service.exception.ObjectNotFoundException;

@Service
public class ColaboradorService {

	
	@Autowired
	ColaboradorRepository colaboradorRepository;

	public Colaborador findById(Integer id) {
		return colaboradorRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
				"Colaborador não encontrado! id: " + id + ", Tipo: " + Colaborador.class.getName()));
	}

	public List<Colaborador> findAll() {
		return colaboradorRepository.findAll();
	}


}
