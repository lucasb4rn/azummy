//package com.lucas.azumy.config.secuity;
//package com.lucas.bookstore.config.secuity;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class WebSecurityConfigV2 {
//	
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		
//		http.headers().frameOptions().disable();
//		http.httpBasic().and().authorizeHttpRequests()
////		.antMatchers(HttpMethod.GET, "/categorias/**").permitAll()
////	    .antMatchers(HttpMethod.POST, "/categorias/**").hasRole("USER")
////		.antMatchers(HttpMethod.DELETE, "/categorias/**").hasRole("ADMIN")
//		.anyRequest().authenticated()
//		.and()
//		.csrf().disable();
//		
//		
//		return http.build();
//	}
//
//	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	
//}
