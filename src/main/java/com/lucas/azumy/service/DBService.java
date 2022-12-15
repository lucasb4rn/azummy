package com.lucas.azumy.service;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lucas.azumy.domain.Avaliacao;
import com.lucas.azumy.domain.Colaborador;
import com.lucas.azumy.domain.Contato;
import com.lucas.azumy.domain.Endereco;
import com.lucas.azumy.domain.InformacoesFisicas;
import com.lucas.azumy.domain.Paciente;
import com.lucas.azumy.domain.Profissional;
import com.lucas.azumy.domain.ResultadoAvaliacao;
import com.lucas.azumy.domain.Sexo;
import com.lucas.azumy.domain.Usuario;
import com.lucas.azumy.enums.Perfil;
import com.lucas.azumy.repositoies.AvaliacaoRepository;
import com.lucas.azumy.repositoies.ColaboradorRepository;
import com.lucas.azumy.repositoies.ContatoRepository;
import com.lucas.azumy.repositoies.EnderecoRepository;
import com.lucas.azumy.repositoies.InformacoesFisicasRepository;
import com.lucas.azumy.repositoies.PacienteRepository;
import com.lucas.azumy.repositoies.ProfissionalRepository;
import com.lucas.azumy.repositoies.ResultadoAvaliacaoRepository;
import com.lucas.azumy.repositoies.UsuarioRepository;

@Service
public class DBService {

	@Autowired
	UsuarioRepository userRepository;

	@Autowired
	ColaboradorRepository colaboradorRepository;

	@Autowired
	ContatoRepository contatoRepository;

	@Autowired
	EnderecoRepository enderecoRepository;

	@Autowired
	ProfissionalRepository profissionalRepository;

	@Autowired
	PacienteRepository pacienteRepository;

	@Autowired
	ResultadoAvaliacaoRepository resultadadoAvaliacaoRepository;

	@Autowired
	InformacoesFisicasRepository informacoesFisicasRepository;

	@Autowired
	AvaliacaoRepository avaliacaoRepository;

	public void instaciaBaseDeDados() {

		Endereco endereco1 = new Endereco("14080-260", "Rua Goias 400", "Ribeirão Preto", "SP", "Brasil");
		Endereco endereco2 = new Endereco("14080-300", "Rua Piris 500", "Ribeirão Preto", "SP", "Brasil");
		Endereco endereco3 = new Endereco("14080-260", "Rua José Campos 70", "Ribeirão Preto", "SP", "Brasil");
		Endereco endereco4 = new Endereco("14080-260", "Rua José Campos 90", "Ribeirão Preto", "SP", "Brasil");

		Contato contato1 = new Contato("16 994157664", "16 994157664", "lucas.b4rn@gmail.com");
		Contato contato2 = new Contato("16 994157664", "16 994157664", "lucas.b4rn@gmail.com");
		Contato contato3 = new Contato("16 994157664", "16 994157664", "lucas.b4rn@gmail.com");
		Contato contato4 = new Contato("16 994157664", "16 994157664", "lucas.b4rn@gmail.com");

		Colaborador colaborador1 = new Colaborador("João Aparecido", "691.470.880-01", "23.173.872-9", Sexo.MASCULINO,
				"30/03/1994", contato1, endereco1);

		Colaborador colaborador3 = new Colaborador("Lucas Aparecido", "458.705.860-20", "32.657.714-2", Sexo.MASCULINO,
				"14/03/1986", contato2, endereco2);

		Colaborador colaborador2 = new Colaborador("Maria", "464.971.110-00", "14.719.455-6", Sexo.FEMININO,
				"19/01/1990", contato3, endereco3);

		Paciente rodolfo = new Paciente("Lucas", "364.220.058-30", "42.302.383-4", Sexo.FEMININO, new Date("07/01/2000"),
				contato4, endereco4);

		InformacoesFisicas informacoesFisicas = new InformacoesFisicas(1.78, 125, 1, 1, 2, 3, 1, 1, 3);

		ResultadoAvaliacao resultadoAvaliacao = new ResultadoAvaliacao(null, 39.4520893826537, 49.563119802922984);

		pacienteRepository.save(rodolfo);

		informacoesFisicasRepository.saveAll(Arrays.asList(informacoesFisicas));
		resultadadoAvaliacaoRepository.saveAll(Arrays.asList(resultadoAvaliacao));
//		InformacoesFisicas informacoes = informacoesFisicasRepository.findById(informacoesFisicas.getId()).get();

		Profissional profissiona3 = new Profissional("Dr. Lucas", colaborador3);
		Profissional profissional = new Profissional("Dr. José", colaborador2);
		Profissional profissional2 = new Profissional("Dr. Marcos", colaborador1);

		this.enderecoRepository.saveAll(Arrays.asList(endereco1, endereco2, endereco3, endereco4));
		this.contatoRepository.saveAll(Arrays.asList(contato1, contato2, contato3, contato4));

		this.colaboradorRepository.saveAll(Arrays.asList(colaborador1, colaborador2, colaborador3));
		this.profissionalRepository.saveAll(Arrays.asList(profissional, profissional2, profissiona3));

		Avaliacao avaliacao = new Avaliacao(null, rodolfo, profissional, informacoesFisicas, resultadoAvaliacao, true);

		avaliacaoRepository.save(avaliacao);

		Usuario user1 = new Usuario(null, "joao", new BCryptPasswordEncoder().encode("joao123"), colaborador1);

		user1.addPerfil(Perfil.ADMIN);

		Usuario user = new Usuario(null, "maria", new BCryptPasswordEncoder().encode("maria123"), colaborador2);

		user.addPerfil(Perfil.ADMIN);

		this.userRepository.saveAll(Arrays.asList(user, user1));

	}

}
