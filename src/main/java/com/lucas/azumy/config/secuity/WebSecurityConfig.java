//package com.lucas.azumy.config.secuity;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
////@Configuration
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Autowired
//	UserDetailsServiceImpl userDetailsService;
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.headers().frameOptions().disable();
//		http.httpBasic().and().authorizeHttpRequests()
//		.antMatchers(HttpMethod.GET, "/categorias/**").permitAll()
//	    .antMatchers(HttpMethod.POST, "/categorias/**").hasRole("USER")
//		.antMatchers(HttpMethod.DELETE, "/categorias/**").hasRole("ADMIN").anyRequest().authenticated()
//		.and()
//		.csrf().disable();
//	}
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//
//}