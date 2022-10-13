package com.lucas.azumy.repositoies;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucas.azumy.domain.Profissional;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Integer>{
	

}
