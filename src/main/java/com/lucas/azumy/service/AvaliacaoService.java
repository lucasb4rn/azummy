package com.lucas.azumy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.azumy.domain.Avaliacao;
import com.lucas.azumy.domain.InformacoesFisicas;
import com.lucas.azumy.domain.Paciente;
import com.lucas.azumy.domain.Profissional;
import com.lucas.azumy.domain.ResultadoAvaliacao;
import com.lucas.azumy.domain.Sexo;
import com.lucas.azumy.dtos.AvaliacaoDTO;
import com.lucas.azumy.repositoies.AvaliacaoRepository;
import com.lucas.azumy.repositoies.ColaboradorRepository;
import com.lucas.azumy.repositoies.PacienteRepository;
import com.lucas.azumy.repositoies.ProfissionalRepository;
import com.lucas.azumy.service.exception.DataIntegrityViolationException;
import com.lucas.azumy.service.exception.ObjectNotFoundException;

@Service
public class AvaliacaoService {

	@Autowired
	ProfissionalRepository profissionalRepository;
	@Autowired
	AvaliacaoRepository repository;
	@Autowired
	PacienteRepository pacienteRepository;
	@Autowired
	ColaboradorRepository colaboradorRepository;
	@Autowired
	ColaboradorService colaboradorService;
	@Autowired
	InformacoesFisicasService informacoesFisicasService;
	@Autowired
	ResultadoAvaliacaoService resultadoAvaliacaoService;

	public Avaliacao findById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
				"Profissional não encontrado! id: " + id + ", Tipo: " + Profissional.class.getName()));
	}

	public Profissional findByIdColaborador(Integer id) {
		return profissionalRepository.findByIdColaborador(id);
	}

	public List<Avaliacao> findAll() {
		return repository.findAll();
	}

	public Avaliacao create(AvaliacaoDTO obj) {
		Profissional profissional = profissionalRepository.findById(obj.getProfissional())
				.orElseThrow(() -> new ObjectNotFoundException(
						"Colaborador não encontrado! id: " + obj.getId() + ", Tipo: " + Profissional.class.getName()));

		Paciente paciente = pacienteRepository.findById(obj.getPaciente())
				.orElseThrow(() -> new ObjectNotFoundException(
						"Paciente não encontrado! id: " + obj.getId() + ", Tipo: " + Paciente.class.getName()));

		InformacoesFisicas createdInformacoesFisicas = informacoesFisicasService.create(obj.getInformacoesFisicas());
		ResultadoAvaliacao resultadoAvaliacao = obj.getResultadoAvaliacao();

		resultadoAvaliacao.setImc(createdInformacoesFisicas.getPeso()
				/ (createdInformacoesFisicas.getAltura() * createdInformacoesFisicas.getAltura()));

		double soma = createdInformacoesFisicas.getMedida1() + createdInformacoesFisicas.getMedida2()
				+ createdInformacoesFisicas.getMedida3() + createdInformacoesFisicas.getMedida4()
				+ createdInformacoesFisicas.getMedida5() + createdInformacoesFisicas.getMedida6()
				+ createdInformacoesFisicas.getMedida7();

		double dc = (1.112 - 0.00043499) - (0.00043 * soma) + (0.00000055 * soma) * 2
				- 0.00028826 * paciente.getIdade();

		double porcentagem = 0;

		porcentagem = (495 / dc) - 450;

		resultadoAvaliacao.setIndiceGorduras(porcentagem * 100);

		ResultadoAvaliacao createdResultadoAvaliacao = resultadoAvaliacaoService.create(resultadoAvaliacao);

		return repository.save(new Avaliacao(null, paciente, profissional, createdInformacoesFisicas,
				createdResultadoAvaliacao, true));
	}

	public Avaliacao update(Avaliacao avaliacao) {
		return repository.save(avaliacao);
	}

	public void delete(Integer id) {

		findById(id);

		try {

			repository.deleteById(id);

		} catch (org.springframework.dao.DataIntegrityViolationException e) {

			throw new DataIntegrityViolationException("Profissional não pode ser deletado!");
		}
	}

}
