package com.skeleton.alumini.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.skeleton.alumini.util.SecurityKeyUtil;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public SecurityKeyUtil passwordEncoderDecoder() {
		SecurityKeyUtil encodeDecode = new SecurityKeyUtil();
		return encodeDecode;
	}

	@Override
	protected void configure(final HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable().anonymous().disable().authorizeRequests().antMatchers("/api-docs/**").permitAll();

	}

}
