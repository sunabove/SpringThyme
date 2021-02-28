package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		var a = auth.inMemoryAuthentication();
		a.withUser("user").password("{noop}user").roles("USER");
		a.withUser("admin").password("{noop}admin").roles("ADMIN");
	}

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		var a = http.authorizeRequests();
		//a.antMatchers( "/*" ).hasRole( "USER" ).anyRequest().permitAll();
		//a.antMatchers( "/**/myCalc.html" ).hasRole( "ADMIN" ).anyRequest().permitAll();
		a.antMatchers("/*").permitAll();
		http.csrf().disable();
	}
}
