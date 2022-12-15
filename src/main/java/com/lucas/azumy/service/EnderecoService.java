package com.lucas.azumy.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.azumy.domain.Endereco;
import com.lucas.azumy.repositoies.EnderecoRepository;
import com.lucas.azumy.service.exception.ObjectNotFoundException;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repository;

	public Endereco findById(Integer id) {
		Optional<Endereco> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
	}

	public Endereco create(Endereco obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Endereco update(Integer id, @Valid Endereco newEndereco) {
		newEndereco.setId(id);
		Endereco oldObj = findById(id);
		return repository.save(oldObj);

	}

	public void delete(Integer id) {
		findById(id);
		repository.deleteById(id);
	}

}
