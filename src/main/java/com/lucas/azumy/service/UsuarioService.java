package com.lucas.azumy.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lucas.azumy.domain.Colaborador;
import com.lucas.azumy.domain.Usuario;
import com.lucas.azumy.dtos.UsuarioDTO;
import com.lucas.azumy.enums.Perfil;
import com.lucas.azumy.repositoies.UsuarioRepository;
import com.lucas.azumy.service.exception.DataIntegrityViolationException;
import com.lucas.azumy.service.exception.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	@Autowired
	private ColaboradorService colaboradorService;
	@Autowired
	private BCryptPasswordEncoder encoder;

	public Usuario findById(Integer id) {
		Optional<Usuario> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
	}

	public List<Usuario> findAll() {
		return repository.findAll();
	}

	public Usuario create(UsuarioDTO obj) {

		Colaborador colaborador = colaboradorService.findById(obj.getColaborador());
		Usuario newUser = new Usuario(obj.getId(), obj.getUsername(), obj.getPassword(), colaborador);
		
		Usuario usuario = repository.findByIdColaborador(obj.getColaborador());
		
		if(usuario != null) {
			throw new DataIntegrityViolationException("Colaborador já vinculado a um Usuário");
		}

		for (Perfil perfil : obj.getPerfis()) {
			newUser.addPerfil(perfil);
		}

		return repository.save(newUser);
	}

	public Usuario update(@Valid UsuarioDTO newUser) {

		Usuario oldObj = this.findById(newUser.getId());

		Set<Perfil> perfis = newUser.getPerfis();

		oldObj.setId(newUser.getId());
		oldObj.setUsername(newUser.getUsername());
		oldObj.setPassword(newUser.getPassword());
		oldObj.setPerfis(newUser.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet()));

		Colaborador colaborador = colaboradorService.findById(oldObj.getColaborador().getId());
		oldObj.setColaborador(colaborador);

		return repository.save(oldObj);

	}

	public void delete(Integer id) {
		Usuario obj = findById(id);
		repository.deleteById(id);
	}

}
