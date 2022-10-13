package com.lucas.azumy.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.azumy.domain.Colaborador;
import com.lucas.azumy.domain.Contato;
import com.lucas.azumy.domain.Endereco;
import com.lucas.azumy.domain.Profissional;
import com.lucas.azumy.domain.Sexo;
import com.lucas.azumy.repositoies.ColaboradorRepository;
import com.lucas.azumy.repositoies.ContatoRepository;
import com.lucas.azumy.repositoies.EnderecoRepository;
import com.lucas.azumy.repositoies.ProfissionalRepository;

@Service
public class DBService {

//
//	@Autowired
//	UserRepository userRepository;
//
//	@Autowired
//	RoleRepository roleRepository;
	
	@Autowired
	ColaboradorRepository colaboradorRepository;
	
	@Autowired
	ContatoRepository contatoRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired
	ProfissionalRepository profissionalRepository;
	
	

	public void instaciaBaseDeDados() {

		Endereco endereco1 = new Endereco("14080260", "Rua Goias 497", "Ribeirão Preto", "Brasil");
		Contato contato1 = new Contato("16994157664", "16994157664", "lucas.b4rn@gmail.com");

		Colaborador colaborador1 = new Colaborador("Marcos Aparecido", "49093960040", "345051646", Sexo.MASCULINO, "30/03/1994",
				contato1, endereco1);
		
		Colaborador colaborador2 = new Colaborador("José Maria", "62865053008", "384797398", Sexo.MASCULINO, "30/03/1994",
				contato1, endereco1);
		
		Profissional profissional = new Profissional("Dr. José", colaborador2);
		Profissional profissional2 = new Profissional("Dr. Marcos", colaborador1);
		
		this.enderecoRepository.save(endereco1);
		this.contatoRepository.save(contato1);
		this.colaboradorRepository.saveAll(Arrays.asList(colaborador1, colaborador2));	
		this.profissionalRepository.saveAll(Arrays.asList(profissional, profissional2));
//		
//		RoleModel roleAdmin = new RoleModel(RoleName.ROLE_ADMIN);
//		RoleModel roleUser = new RoleModel(RoleName.ROLE_USER);
//		this.roleRepository.saveAll(Arrays.asList(roleAdmin, roleUser));
//
//		UserModel user = new UserModel("maria", new BCryptPasswordEncoder().encode("maria123"),
//				Arrays.asList(roleAdmin));
//		UserModel user1 = new UserModel("joao", new BCryptPasswordEncoder().encode("joao123"), Arrays.asList(roleUser));
		
		
	
//		this.userRepository.saveAll(Arrays.asList(user, user1));
//		

	}

}
