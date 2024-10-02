package com.bookwise.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;

import com.okta.spring.boot.oauth.Okta;

@Configuration
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(auth -> {
					auth.requestMatchers("/api/books/secure/**").authenticated()
					.anyRequest().permitAll();
				}).oauth2ResourceServer().jwt();
		
		//add cors filter
		http.cors();
		
		//Add content negotiation strategy
		http.setSharedObject(ContentNegotiationStrategy.class, new HeaderContentNegotiationStrategy());
		
		//Force a non-empty response body for 401's to make the response friendly
		Okta.configureResourceServer401ResponseBody(http);
		
		return http.build();
				
	}
}
