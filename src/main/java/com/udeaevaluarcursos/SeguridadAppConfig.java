package com.udeaevaluarcursos;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@configuration
@EnableWebSecurity
public class SeguridadAppConfig extends WebSecurityConfigurerAdapter {

	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		UserBuilder usuarios=User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication().WithUser(usuarios.username("example@udea.edu.co").password("password").roles("student"));
		
	}
	
}

