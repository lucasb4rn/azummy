package com.lucas.azumy.service;


import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.azumy.domain.Endereco;
import com.lucas.azumy.domain.InformacoesFisicas;
import com.lucas.azumy.repositoies.InformacoesFisicasRepository;
import com.lucas.azumy.service.exception.ObjectNotFoundException;

@Service
public class InformacoesFisicasService {

	@Autowired
	private InformacoesFisicasRepository repository;

	public InformacoesFisicas findById(Integer id) {
		Optional<InformacoesFisicas> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
	}

	public InformacoesFisicas create(InformacoesFisicas obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public InformacoesFisicas update(Integer id, @Valid InformacoesFisicas newInformacoesFisicas) {
		newInformacoesFisicas.setId(id);
		InformacoesFisicas oldObj = findById(id);
		return repository.save(oldObj);

	}

	public void delete(Integer id) {
		findById(id);
		repository.deleteById(id);
	}

}
