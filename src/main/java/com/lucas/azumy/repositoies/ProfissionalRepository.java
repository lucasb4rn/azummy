package com.lucas.azumy.repositoies;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lucas.azumy.domain.Profissional;


public interface ProfissionalRepository extends JpaRepository<Profissional, Integer>{

	@Query("SELECT p FROM  Profissional p WHERE p.colaborador.id = :id")
	Profissional findByIdColaborador(@Param("id") Integer id);
	

}
