package com.gft.palmirinha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import com.gft.palmirinha.service.SecurityService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(securityService).passwordEncoder(NoOpPasswordEncoder.getInstance());
	}
	
	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.authorizeRequests()
		      //.antMatchers("/").permitAll()
		      //.antMatchers("/login").permitAll()
		      .antMatchers("/receitas/editar").hasAnyRole("MANAGERS")
		      .antMatchers("/managers").hasAnyRole("MANAGERS")
		      .antMatchers("/users").hasAnyRole("USERS","MANAGERS")
		      .anyRequest().authenticated().and()
		      .formLogin()//formLogin httpBasic
		     
              .defaultSuccessUrl("/home", true);
	}
	/*
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		        .withUser("user")
		        .password("{noop}user123")
		        .roles("USERS")
		        .and()
		        .withUser("admin")
		        .password("{noop}admin123")
		        .roles("MANAGERS"); 
	}*/

}
