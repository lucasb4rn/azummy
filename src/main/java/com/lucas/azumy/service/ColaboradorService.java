package com.lucas.azumy.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.azumy.Helper.ValidaCPF;
import com.lucas.azumy.domain.Colaborador;
import com.lucas.azumy.domain.Contato;
import com.lucas.azumy.domain.Endereco;
import com.lucas.azumy.domain.Paciente;
import com.lucas.azumy.domain.Profissional;
import com.lucas.azumy.domain.Usuario;
import com.lucas.azumy.repositoies.ColaboradorRepository;
import com.lucas.azumy.service.exception.DataIntegrityViolationException;
import com.lucas.azumy.service.exception.ObjectNotFoundException;

@Service
public class ColaboradorService {

	@Autowired
	ColaboradorRepository colaboradorRepository;

	@Autowired
	EnderecoService enderecoService;

	@Autowired
	ContatoService contatoService;

	public Colaborador findById(Integer id) {
		return colaboradorRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
				"Colaborador não encontrado! id: " + id + ", Tipo: " + Colaborador.class.getName()));
	}

	public List<Colaborador> findAll() {
		return colaboradorRepository.findAll();
	}

	public Colaborador create(Colaborador obj) {

		obj.setId(null);
		
		if(!ValidaCPF.isCPF(obj.getCpf())) throw new DataIntegrityViolationException("CPF INVÁLIDO!");
		
		Optional<Colaborador> findByCpf = colaboradorRepository.findByCpf(obj.getCpf());
		
		if(findByCpf.isPresent()) throw new DataIntegrityViolationException("CPF JÁ CADASTRADO!");

		Endereco savedEndereco = enderecoService.create(obj.getEndereco());
		Contato savedContato = contatoService.create(obj.getContato());

		obj.setContato(savedContato);
		obj.setEndereco(savedEndereco);

		return colaboradorRepository.save(obj);

	}

	public Colaborador update(@Valid Colaborador newUser) {

		Optional<Colaborador> findByCpf = colaboradorRepository.findByCpf(newUser.getCpf());
		
		Colaborador oldObj = this.findById(newUser.getId());

		Endereco newEndereco = newEndereco(newUser.getEndereco());
		Contato newContato = newContato(newUser.getContato());

		oldObj.setContato(newContato);
		oldObj.setEndereco(newEndereco);

		oldObj.setCpf(newUser.getCpf());
		oldObj.setDataNascimento(newUser.getDataNascimento());
		oldObj.setNome(newUser.getNome());
		oldObj.setSexo(newUser.getSexo());
		oldObj.setRg(newUser.getRg());

		return colaboradorRepository.save(oldObj);

	}

	public void delete(Integer id) {
		findById(id);
		colaboradorRepository.deleteById(id);
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
