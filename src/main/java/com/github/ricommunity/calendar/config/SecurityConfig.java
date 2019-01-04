package com.github.ricommunity.calendar.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()	
				.antMatchers("/admin/**").hasRole("ADMIN")
				.antMatchers("/**").permitAll()			
				.and()
			.formLogin().loginPage("/login").permitAll().and()
			.logout()
	            .invalidateHttpSession(true)
	            .clearAuthentication(true)
	            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	            .logoutSuccessUrl("/login?logout")
	            .permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		String user = ConfigService.getVariable("ADMIN_NAME","user");
		String pwd = ConfigService.getVariable("ADMIN_PWD","password");
		auth
			.inMemoryAuthentication()
				.withUser(user).password("{noop}" + pwd).roles("ADMIN");
	}
}
