package com.lucas.azumy.repositoies;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lucas.azumy.domain.Colaborador;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer>{

	@Query("SELECT c FROM  Colaborador c WHERE c.cpf = :cpf")
	Optional<Colaborador> findByCpf(@Param("cpf") String cpf);

}
