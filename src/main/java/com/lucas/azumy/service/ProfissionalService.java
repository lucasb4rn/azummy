package com.lucas.azumy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.azumy.domain.Colaborador;
import com.lucas.azumy.domain.Profissional;
import com.lucas.azumy.dtos.ProfissionalDTO;
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
	@Autowired
	ColaboradorService colaboradorService;

	public Profissional findById(Integer id) {
		return profissionalRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
				"Profissional não encontrado! id: " + id + ", Tipo: " + Profissional.class.getName()));
	}

	public Profissional findByIdColaborador(Integer id) {
		return profissionalRepository.findByIdColaborador(id);
	}

	public List<Profissional> findAll() {
		return profissionalRepository.findAll();
	}

	public Profissional create(ProfissionalDTO obj) {

		Colaborador colaborador = colaboradorRepository.findById(obj.getColaborador())
				.orElseThrow(() -> new ObjectNotFoundException("Colaborador não encontrado! id: " + obj.getColaborador()
						+ ", Tipo: " + Colaborador.class.getName()));

		Profissional verificaSeExiste = findByIdColaborador(obj.getColaborador());

		if (verificaSeExiste != null) {
			throw new DataIntegrityViolationException("Colaborador já vinculado a um profissional");
		}

		Profissional profissional = new Profissional(obj.getNome(), colaborador);

		return profissionalRepository.save(profissional);
	}

	public Profissional update(ProfissionalDTO objDTO) {
		
		Profissional obj = findById(objDTO.getId());
		
		Profissional verificaSeExiste = findByIdColaborador(objDTO.getColaborador());

		if (verificaSeExiste != null) {
			throw new DataIntegrityViolationException("Colaborador já vinculado a um profissional");
		}

		obj.setNome(objDTO.getNome());
		obj.setColaborador(colaboradorService.findById(objDTO.getColaborador()));
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
