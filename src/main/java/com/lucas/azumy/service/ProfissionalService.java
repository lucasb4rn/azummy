package com.lucas.azumy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.azumy.domain.Colaborador;
import com.lucas.azumy.domain.Profissional;
import com.lucas.azumy.repositoies.ColaboradorRepository;
import com.lucas.azumy.repositoies.ProfissionalRepository;
import com.lucas.azumy.service.exception.DataIntegrityViolationException;
import com.lucas.azumy.service.exception.ObjectNotFoundException;

@Service
public class ProfissionalService {

	@Autowired
	ProfissionalRepository profissionalRepository;
	
	@Autowired
	ColaboradorRepository colaboradorRepository;

	public Profissional findById(Integer id) {
		return profissionalRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
				"Profissional não encontrado! id: " + id + ", Tipo: " + Profissional.class.getName()));
	}

	public List<Profissional> findAll() {
		return profissionalRepository.findAll();
	}

	public Profissional create(Profissional obj) {
		obj.setId(null);
		colaboradorRepository.findById(obj.getColaborador().getId()).orElseThrow(() -> new ObjectNotFoundException(
				"Colaborador não encontrado! id: " + obj.getColaborador().getId() + ", Tipo: " + Colaborador.class.getName()));;
		return profissionalRepository.save(obj);

	}

	public Profissional update(Integer id, Profissional objDTO) {
		Profissional obj = findById(id);
		obj.setNome(objDTO.getNome());
		obj.setColaborador(objDTO.getColaborador());
		return profissionalRepository.save(obj);
	}

	public void delete(Integer id) {
		findById(id);
		try {
			profissionalRepository.deleteById(id);
		} catch (org.springframework.dao.DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Profissional não pode ser deletado!");
		}
	}

}
