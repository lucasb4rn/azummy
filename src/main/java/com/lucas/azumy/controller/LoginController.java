package com.lucas.azumy.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.azumy.config.security.UserDetailsServiceImpl;
import com.lucas.azumy.domain.Usuario;

@CrossOrigin(origins = "*", maxAge = 4800)
@RestController
@RequestMapping(value = "/login")
public class LoginController {

	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;

	@PostMapping
	public ResponseEntity<Usuario> validate(@Valid @RequestBody Usuario obj) {
			userDetailsServiceImpl.loadUserByUsername(obj.getUsername());
			return ResponseEntity.ok(obj);
	}

}
