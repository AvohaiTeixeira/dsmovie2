package com.atos.dsmovie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	MvcRequestMatcher movies = new MvcRequestMatcher(null, "/movies");
	MvcRequestMatcher movieById = new MvcRequestMatcher(null, "/movies/*");
	
	@Bean
	SecurityFilterChain securityFilterChain (HttpSecurity http ) throws Exception {
		return http
			.authorizeHttpRequests(
					authorizeConfig -> {
						authorizeConfig.requestMatchers(movies).permitAll();
						authorizeConfig.requestMatchers(movieById).permitAll();
						authorizeConfig.anyRequest().authenticated();	
					}).build();
	}

}
