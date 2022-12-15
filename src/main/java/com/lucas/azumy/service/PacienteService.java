package com.lucas.azumy.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.azumy.Helper.ValidaCPF;
import com.lucas.azumy.domain.Colaborador;
import com.lucas.azumy.domain.Contato;
import com.lucas.azumy.domain.Endereco;
import com.lucas.azumy.domain.Paciente;
import com.lucas.azumy.repositoies.PacienteRepository;
import com.lucas.azumy.service.exception.DataIntegrityViolationException;
import com.lucas.azumy.service.exception.ObjectNotFoundException;

@Service
public class PacienteService {

	@Autowired
	PacienteRepository pacienteRepository;

	@Autowired
	ContatoService contatoService;
	
	@Autowired
	EnderecoService enderecoService;

	public Paciente findById(Integer id) {
		return pacienteRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
				"Colaborador não encontrado! id: " + id + ", Tipo: " + Colaborador.class.getName()));
	}

	public List<Paciente> findAll() {
		return pacienteRepository.findAll();
	}

	public Paciente create(Paciente obj) throws Exception {

		obj.setId(null);

		if(!ValidaCPF.isCPF(obj.getCpf())) {
			throw new DataIntegrityViolationException("CPF INVÁLIDO!");
		}

		Endereco savedEndereco = enderecoService.create(obj.getEndereco());
		Contato savedContato = contatoService.create(obj.getContato());

		obj.setContato(savedContato);
		obj.setEndereco(savedEndereco);

		return pacienteRepository.save(obj);

	}
	
	public Paciente update(@Valid Paciente newUser) {

		Paciente oldObj = this.findById(newUser.getId());
		oldObj.setContato(newUser.getContato());
		
		Endereco newEndereco = newEndereco(newUser.getEndereco());
		Contato newContato = newContato(newUser.getContato());
		
		
		oldObj.setEndereco(newEndereco);
		oldObj.setContato(newContato);
		oldObj.setCpf(newUser.getCpf());
		oldObj.setDataNascimento(newUser.getDataNascimento());
		oldObj.setNome(newUser.getNome());
		oldObj.setSexo(newUser.getSexo());
		oldObj.setRg(newUser.getRg());
		
		return pacienteRepository.save(oldObj);

	}

	public void delete(Integer id) {
		findById(id);
		pacienteRepository.deleteById(id);
	}

	
	public Endereco newEndereco(Endereco newEndereco) {
		
		Endereco endereco = enderecoService.findById(newEndereco.getId());
		
		endereco.setCep(newEndereco.getEndereco());
		endereco.setCidade(newEndereco.getCidade());
		endereco.setUf(newEndereco.getUf());
		endereco.setPais(newEndereco.getPais());
		
		return endereco;
		
	}
	
	
	public Contato newContato(Contato newContato) {
		
		Contato contato = contatoService.findById(newContato.getId());
		
		contato.setCelular(newContato.getCelular());
		contato.setEmail(newContato.getEmail());
		contato.setTelefone(newContato.getTelefone());
		
		return contato;
		
	}
	

}
