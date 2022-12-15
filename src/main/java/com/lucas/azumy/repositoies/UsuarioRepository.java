package com.lucas.azumy.repositoies;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lucas.azumy.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	Optional<Usuario> findByUsername(String username);

	@Query("SELECT u FROM  Usuario u WHERE u.colaborador.id = :id")
	Usuario findByIdColaborador(@Param("id") Integer id);


}
