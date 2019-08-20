package com.alc.itautwitter.settings.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * The type Security configuration.
 */
@Configuration()
public class SecurityConfiguration
	extends WebSecurityConfigurerAdapter {

	/**
	 * Configure.
	 *
	 * @param httpSecurity the http security
	 *
	 * @throws Exception the exception
	 */
	@Override()
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
			.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/h2/**").permitAll()
			.antMatchers("/h2_console/**").permitAll();

		httpSecurity.csrf().disable();
		httpSecurity.headers().frameOptions().disable();
	}

}
