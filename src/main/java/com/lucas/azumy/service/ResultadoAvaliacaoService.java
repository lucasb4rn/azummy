package com.lucas.azumy.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.azumy.domain.Endereco;
import com.lucas.azumy.domain.ResultadoAvaliacao;
import com.lucas.azumy.repositoies.ResultadoAvaliacaoRepository;
import com.lucas.azumy.service.exception.ObjectNotFoundException;

@Service
public class ResultadoAvaliacaoService {

	@Autowired
	private ResultadoAvaliacaoRepository repository;

	public ResultadoAvaliacao findById(Integer id) {
		Optional<ResultadoAvaliacao> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
	}

	public ResultadoAvaliacao create(ResultadoAvaliacao obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public ResultadoAvaliacao update(Integer id, @Valid ResultadoAvaliacao newResultado) {
		newResultado.setId(id);
		ResultadoAvaliacao oldObj = findById(id);
		return repository.save(oldObj);

	}

	public void delete(Integer id) {
		findById(id);
		repository.deleteById(id);
	}

}
