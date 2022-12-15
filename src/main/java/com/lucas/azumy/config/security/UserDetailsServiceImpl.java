package com.lucas.azumy.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lucas.azumy.domain.Usuario;
import com.lucas.azumy.repositoies.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UsuarioRepository userRepository;

	@Override
	public UserSS loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = userRepository.findByUsername(username).orElseThrow(
				() -> new UsernameNotFoundException("Usuario não encontrado com nome Usuario: " + username));
		
		return new UserSS(usuario.getId(), usuario.getUsername(), usuario.getPassword(), usuario.getPerfis());
	}

}
