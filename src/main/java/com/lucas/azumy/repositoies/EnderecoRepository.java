package com.lucas.azumy.repositoies;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucas.azumy.domain.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{
	

}
