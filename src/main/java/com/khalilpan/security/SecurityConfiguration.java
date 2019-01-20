package com.khalilpan.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//to set the "security" of "spring security" we should extend "WebSecurityConfigurerAdapter" ,to be able to add our own security configuration
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	// creating user password for login (dummy)

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {

		authenticationManagerBuilder.inMemoryAuthentication().withUser("khalil").password("{noop}123").roles("USER",
				"ADMIN");

//if it throw exception {There is no PasswordEncoder mapped for the id "null"} ,to solve it
//we can add "{noop}" to the password field ==> ...withUser("khalil").password("{noop}123").roles("USER","ADMIN");
	}

	
	//to create a specific "user name and password page" ,not using the security´s default "asking user password"
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers("/login").permitAll()//means=everybody that going to page "/login" ,permit them,hey can see this page
			.antMatchers("/","/*todo*/**").access("hasRole('USER')").and().formLogin();
			//means=the people that has role of ('USER')can access to root page("/") or any of "todo"pages
	}

	
	
	
	
	
}
