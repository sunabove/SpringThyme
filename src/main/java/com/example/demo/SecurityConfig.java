package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		log.info( "#".repeat( 80 ));
		log.info( "HttpSecurity http" );
		log.info( "#".repeat( 80 ));
		
		http
		.authorizeRequests()
			.antMatchers("/", "/home", "/index.html").permitAll()
			.anyRequest().authenticated()
			.and()
		.formLogin()
			.loginPage("/login")
			.permitAll()
			.and()
		.logout()
			.permitAll();
		
		http.csrf().disable();
	}
	
	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		log.info( "#".repeat( 80 ));
		log.info( "userDetailsService" );
		log.info( "#".repeat( 80 ));
		
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("admin")
				.password("admin")
				.roles("admin") 
				.username("user")
				.password("user")
				.roles("user") 
				.build();

		return new InMemoryUserDetailsManager(user);
	}
}
