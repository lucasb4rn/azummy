package com.lucas.azumy.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.azumy.domain.Contato;
import com.lucas.azumy.domain.Usuario;
import com.lucas.azumy.repositoies.ContatoRepository;
import com.lucas.azumy.service.exception.ObjectNotFoundException;

@Service
public class ContatoService {

	@Autowired
	private ContatoRepository repository;

	public Contato findById(Integer id) {
		Optional<Contato> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
	}

	public Contato create(Contato obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Contato update(Integer id, @Valid Contato newContato) {
		newContato.setId(id);
		Contato oldObj = findById(id);
		return repository.save(oldObj);
	}

	public void delete(Integer id) {
		Contato obj = findById(id);
		repository.deleteById(id);
	}

}
